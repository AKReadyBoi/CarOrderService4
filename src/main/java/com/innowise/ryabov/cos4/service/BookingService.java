package com.innowise.ryabov.cos4.service;

import com.innowise.ryabov.cos4.dto.BookingDTO;
import com.innowise.ryabov.cos4.request.BookingRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {
    List<BookingDTO> getAllBookings();
    void saveBooking(BookingRequest bookingRequest);
    BookingDTO updateBooking(Long id, BookingRequest bookingRequest);
    void deleteBooking(Long id);
    BookingDTO getBooking(Long id);
}
