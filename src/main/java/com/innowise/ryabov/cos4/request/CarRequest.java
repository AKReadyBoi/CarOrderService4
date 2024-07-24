package com.innowise.ryabov.cos4.request;
import java.math.BigDecimal;
import java.util.Date;
public record CarRequest(

        String brand,

        String model,

        Date yearOfProduction,

        String plateNumber,

        BigDecimal dailyFee) {
}
