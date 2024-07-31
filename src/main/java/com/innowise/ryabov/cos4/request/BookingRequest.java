package com.innowise.ryabov.cos4.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record BookingRequest(
        @NotNull(message = "Starting time must not be empty")
        @PastOrPresent(message = "Starting time must be valid")
        LocalDate startDateTime,
        @NotNull(message = "Ending time must not be empty")
        @Future(message = "Ending time must be valid")
        LocalDate endDateTime,
        @NotNull(message = "Status must not be empty")
        String status) {
}
