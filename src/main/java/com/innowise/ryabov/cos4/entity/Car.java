package com.innowise.ryabov.cos4.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String brand;
    String model;
    LocalDate yearOfProduction;
    String plateNumber;
    Boolean isAvailable;
    BigDecimal dailyFee;
    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;
}
