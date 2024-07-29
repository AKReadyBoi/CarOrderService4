package com.innowise.ryabov.cos4.messages;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertyUtil {
    public static final String VALIDATION_MESSAGE = "Validation error(s): ";
    public static final String USER_NOT_FOUND_MESSAGE = "User not found for this id : ";
    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server Error: ";
    public static final String CAR_NOT_FOUND_MESSAGE = "Car not found for this id : ";
    public static final String BRAND_MUST_BE_VALID = "Brand must be valid";
    public static final String MODEL_MUST_BE_VALID = "Model must be valid";
    public static final String YEAR_OF_PRODUCTION_MUST_BE_VALID = "Year of production must be valid";
    public static final String PLATE_NUMBER_CANNOT_BE_EMPTY = "Plate number cannot be empty";
    public static final String PLATE_NUMBER_DOES_NOT_MATCH_BELORUSSIAN_PATTERN = "Plate number does not match belorussian pattern";
    public static final String DAILY_FEE_CANNOT_BE_ZERO = "Daily fee cannot be zero";
    public static final String DAILY_FEE_MUST_BE_A_POSITIVE_VALUE = "Daily fee must be a positive value";
    public static final String FIRSTNAME_CANNOT_BE_EMPTY = "Firstname cannot be empty";
    public static final String LASTNAME_CANNOT_BE_EMPTY = "Lastname cannot be empty";
    public static final String YEAR_OF_PRODUCTION_MUST_MATCH_DATE_PATTERN_YYYY_MM_DD = "Year of production must match date pattern(yyyy-MM-dd)";
    public static final String CREATION_DATE_MUST_BE_VALID = "Creation date must be valid";
    public static final String DRIVING_LICENSE_MUST_BE_VALID = "Driving license must be valid";
    public static final String EMAIL_MUST_BE_VALID = "Email must be valid";
    public static final String PASSPORT_ID_MUST_BE_VALID = "Passport id must be valid";
    public static final String PHONE_NUMBER_MUST_BE_VALID = "Phone number must be valid";
    public static final String THIS_PASSPORT_ID_IS_ALREADY_EXISTING = "This passport id is already existing";
    public static final String THIS_PHONE_NUMBER_IS_ALREADY_EXISTING = "This phone number is already existing";

}
