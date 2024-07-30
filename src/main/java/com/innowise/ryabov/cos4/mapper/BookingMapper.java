package com.innowise.ryabov.cos4.mapper;

import com.innowise.ryabov.cos4.dto.BookingDTO;
import com.innowise.ryabov.cos4.entity.Booking;
import com.innowise.ryabov.cos4.request.BookingRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingDTO bookingToBookingDTO(Booking booking);
    Booking bookingRequestToBooking(BookingRequest request);
}
