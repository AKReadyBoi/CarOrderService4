package com.innowise.ryabov.cos4.util;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookingNotFoundException extends RuntimeException{
    String message;
}
