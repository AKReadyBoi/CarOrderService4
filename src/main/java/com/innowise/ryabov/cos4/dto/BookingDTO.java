package com.innowise.ryabov.cos4.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class BookingDTO {
    LocalDate startDateTime;
    LocalDate endDateTime;
    String status;
}
