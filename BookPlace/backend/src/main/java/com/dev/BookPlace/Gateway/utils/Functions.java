package com.dev.BookPlace.Gateway.utils;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
public class Functions {

    public BigDecimal converterValueDoubleToBigDecimalNoDecimal(Double value) {
        BigDecimal unitAmount = new BigDecimal(value);
        BigDecimal unitAmountInCents = unitAmount.multiply(BigDecimal.valueOf(100)).setScale(0, RoundingMode.HALF_UP);
        long unitAmountLong = unitAmountInCents.longValue();
        return BigDecimal.valueOf(unitAmountLong);
    }

    public String getFormattedDate(Instant data) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(data, ZoneId.systemDefault());
        String formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd").format(dateTime);
        return formattedDate;
    }
}
