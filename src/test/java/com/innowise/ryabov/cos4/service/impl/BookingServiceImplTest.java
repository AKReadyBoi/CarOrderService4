package com.innowise.ryabov.cos4.service.impl;

import com.innowise.ryabov.cos4.dto.BookingDTO;
import com.innowise.ryabov.cos4.entity.Booking;
import com.innowise.ryabov.cos4.mapper.BookingMapper;
import com.innowise.ryabov.cos4.repository.BookingRepository;
import com.innowise.ryabov.cos4.request.BookingRequest;
import com.innowise.ryabov.cos4.util.BookingNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {
    @Mock
    BookingRepository bookingRepository;
    @Mock
    BookingMapper mapper;
    @InjectMocks
    BookingServiceImpl bookingService;
    @Test
    void getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking());

        when(bookingRepository.findAll()).thenReturn(bookings);
        when(mapper.bookingToBookingDTO(Mockito.any(Booking.class))).thenReturn(new BookingDTO());

        assertNotNull(bookingService.getAllBookings());
    }

    @Test
    void saveBooking() {
        BookingRequest request = new BookingRequest(null,
                null,
                null
        );

        when(mapper.bookingRequestToBooking(request)).thenReturn(new Booking());

        bookingService.saveBooking(request);

        verify(bookingRepository, times(1)).save(new Booking());
    }

    @Test
    void updateBooking() {
        Long id = 1L;
        BookingRequest request = new BookingRequest(null,
                null,
                null
        );
        Booking booking = new Booking();

        when(bookingRepository.findById(Mockito.any())).thenReturn(Optional.of(booking));

        bookingService.updateBooking(id, request);

        assertEquals(request.endDateTime(), booking.getEndDateTime());
        assertEquals(request.startDateTime(), booking.getStartDateTime());
        assertEquals(request.status(), booking.getStatus());

    }

    @Test
    void deleteCar() {
        Long id = 1L;
        Booking booking = new Booking();

        when(bookingRepository.findById(Mockito.any())).thenReturn(Optional.of(booking));

        bookingService.deleteBooking(id);

        verify(bookingRepository, times(1)).deleteById(booking.getId());
    }

    @Test
    void getCar() {
        Long id = 1L;
        Booking booking = new Booking();

        when(mapper.bookingToBookingDTO(any(Booking.class))).thenReturn(new BookingDTO());
        when(bookingRepository.findById(Mockito.any())).thenReturn(Optional.of(booking));

        bookingService.getBooking(id);

        verify(bookingRepository, times(1)).findById(id);
    }
    @Test
    void deleteCar_ThrowsCarNotFoundException() {
        Long id = 1L;

        when(bookingRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(BookingNotFoundException.class, () -> bookingService.deleteBooking(id));
    }
    @Test
    void updateCar_ThrowsCarNotFoundException() {
        Long id = 1L;
        BookingRequest request = new BookingRequest(null,
                null,
                null
        );

        when(bookingRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(BookingNotFoundException.class, () -> bookingService.updateBooking(id,request));
    }
    @Test
    void getCar_ThrowsCarNotFoundException() {
        Long id = 1L;

        when(bookingRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(BookingNotFoundException.class, () -> bookingService.getBooking(id));
    }
}