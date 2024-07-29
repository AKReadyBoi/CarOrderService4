package com.innowise.ryabov.cos4.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertyUtil {
    public static final String VALIDATION_MESSAGE = "Validation error(s): ";
    public static final String USER_NOT_FOUND_MESSAGE = "User not found for this id : ";
    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server Error: ";
    public static final String PAYMENT_NOT_FOUND_MESSAGE = "Payment not found for this id : ";
    public static final String DAILY_FEE_MUST_BE_A_POSITIVE_VALUE = "Daily fee must be a positive value";
}
