package com.innowise.ryabov.cos4.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentDTO {
    String status;
    BigDecimal paymentAmount;
    LocalDate paymentDate;
    URL url;
}
