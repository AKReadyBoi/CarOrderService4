package com.innowise.ryabov.cos4.request;

import com.innowise.ryabov.cos4.messages.PropertyUtil;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
public record PaymentRequest(
        @NotNull
        String status,
        @NotNull
        @DecimalMin(value = "0.0", inclusive = false, message = PropertyUtil.DAILY_FEE_MUST_BE_A_POSITIVE_VALUE)
        BigDecimal paymentAmount,
        @NotNull
        @PastOrPresent
        LocalDate paymentDate,
        @NotNull
        URL url) {

}
