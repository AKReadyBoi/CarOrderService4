package com.innowise.ryabov.cos4.entity;
import jakarta.persistence.*;
import lombok.*;

import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstname;
    String lastname;
    String email;
    String phoneNumber;
    LocalDate creationDate;
    String passportId;
    String drivingLicenseId;
    @OneToMany(mappedBy = "user")
    List<Car> cars;
}