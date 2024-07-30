package com.innowise.ryabov.cos4.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate startDateTime;
    LocalDate endDateTime;
    String status;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    Users user;
    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    Car car;
}
