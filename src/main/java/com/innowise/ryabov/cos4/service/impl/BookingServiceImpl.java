package com.innowise.ryabov.cos4.service.impl;

import com.innowise.ryabov.cos4.dto.BookingDTO;
import com.innowise.ryabov.cos4.entity.Booking;
import com.innowise.ryabov.cos4.entity.Car;
import com.innowise.ryabov.cos4.mapper.BookingMapper;
import com.innowise.ryabov.cos4.messages.PropertyUtil;
import com.innowise.ryabov.cos4.repository.BookingRepository;
import com.innowise.ryabov.cos4.request.BookingRequest;
import com.innowise.ryabov.cos4.service.BookingService;
import com.innowise.ryabov.cos4.util.BookingNotFoundException;
import com.innowise.ryabov.cos4.util.CarNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.innowise.ryabov.cos4.messages.PropertyUtil.BOOKING_NOT_FOUND_MESSAGE;

@Service
@Transactional
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    BookingRepository bookingRepository;
    BookingMapper mapper;
    @Override
    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(mapper::bookingToBookingDTO)
                .toList();
    }

    @Override
    public void saveBooking(BookingRequest bookingRequest) {
        bookingRepository.save(mapper.bookingRequestToBooking(bookingRequest));
    }

    @Override
    public BookingDTO updateBooking(Long id, BookingRequest bookingRequest) {
        Booking booking = findSafe(id);
        booking.setStartDateTime(bookingRequest.startDateTime());
        booking.setEndDateTime(bookingRequest.endDateTime());
        booking.setStatus(booking.getStatus());
        return mapper.bookingToBookingDTO(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        val booking = findSafe(id);
        bookingRepository.deleteById(booking.getId());
    }

    @Override
    public BookingDTO getBooking(Long id) {
        return mapper.bookingToBookingDTO(findSafe(id));
    }
    private Booking findSafe(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(
                        () -> new BookingNotFoundException(BOOKING_NOT_FOUND_MESSAGE)
                );
    }
}
