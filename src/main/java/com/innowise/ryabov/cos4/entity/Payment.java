package com.innowise.ryabov.cos4.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long sessionId;
    String status;
    URL url;
    BigDecimal paymentAmount;
    LocalDate paymentDate;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
}