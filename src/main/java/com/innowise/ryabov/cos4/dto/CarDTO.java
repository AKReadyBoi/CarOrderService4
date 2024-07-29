package com.innowise.ryabov.cos4.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarDTO {
    String brand;
    String model;
    Date yearOfProduction;
    String plateNumber;
    BigDecimal dailyFee;
}
