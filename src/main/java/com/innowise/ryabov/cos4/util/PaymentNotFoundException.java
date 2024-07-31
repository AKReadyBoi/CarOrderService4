package com.innowise.ryabov.cos4.util;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class PaymentNotFoundException extends RuntimeException{
    String message;
}