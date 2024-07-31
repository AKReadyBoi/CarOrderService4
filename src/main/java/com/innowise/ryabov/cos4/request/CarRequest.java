package com.innowise.ryabov.cos4.request;
import com.innowise.ryabov.cos4.repository.CarRepository;
import com.innowise.ryabov.cos4.annotations.UniqueValue;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDate;
import static com.innowise.ryabov.cos4.messages.PropertyUtil.*;
public record CarRequest(
        @NotNull(message = BRAND_MUST_BE_VALID)
        String brand,
        @NotNull(message = MODEL_MUST_BE_VALID)
        String model,
        @NotNull(message = YEAR_OF_PRODUCTION_MUST_BE_VALID)
        @PastOrPresent(message = YEAR_OF_PRODUCTION_MUST_BE_VALID)
        LocalDate yearOfProduction,
        @NotNull(message = PLATE_NUMBER_CANNOT_BE_EMPTY)
        @Pattern(regexp = "^\\d{4} [A-Z]{2}-\\d|\\d{4} [A-Z][A-Z]{2}-\\d$",
                message = PLATE_NUMBER_DOES_NOT_MATCH_BELORUSSIAN_PATTERN
        )
        @UniqueValue(repository = CarRepository.class, field = "plateNumber", message = "plate number is already exists")
        String plateNumber,
        @NotNull(message = DAILY_FEE_CANNOT_BE_ZERO)
        @DecimalMin(value = "0.0", inclusive = false, message = DAILY_FEE_MUST_BE_A_POSITIVE_VALUE)
        BigDecimal dailyFee)
{
}
