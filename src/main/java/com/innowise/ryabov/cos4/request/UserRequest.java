package com.innowise.ryabov.cos4.request;
import com.innowise.ryabov.cos4.annotations.UniqueValue;
import com.innowise.ryabov.cos4.repository.UserRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import static com.innowise.ryabov.cos4.messages.PropertyUtil.*;
public record UserRequest(
        @NotEmpty(message = FIRSTNAME_CANNOT_BE_EMPTY)
        String firstname,
        @NotEmpty(message = LASTNAME_CANNOT_BE_EMPTY)
        String lastname,
        @NotEmpty(message = DRIVING_LICENSE_MUST_BE_VALID)
        @Pattern(regexp = "^[A-Z]{2}\\d{6}[A-Z]$")
        @UniqueValue(repository = UserRepository.class, field = "drivingLicenseId")
        String drivingLicenseId,
        @Email
        @NotEmpty(message = EMAIL_MUST_BE_VALID)
        @UniqueValue(repository = UserRepository.class, field = "email")
        String email,
        @NotEmpty(message = PASSPORT_ID_MUST_BE_VALID)
        @Pattern(regexp = "^[A-Z]{2}\\d{7}$")
        @UniqueValue(repository = UserRepository.class, field = "passportId")
        String passportId,
        @NotEmpty(message = PHONE_NUMBER_MUST_BE_VALID)
        @Pattern(regexp = "^\\+375(25|29|33|44)\\d{7}$")
        @UniqueValue(repository = UserRepository.class, field = "phoneNumber")
        String phoneNumber
        ) {

}
