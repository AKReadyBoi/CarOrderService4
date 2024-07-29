package com.innowise.ryabov.cos4.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    String firstname;
    String lastname;
    String drivingLicenseId;
    String email;
    String passportId;
    String phoneNumber;
}
