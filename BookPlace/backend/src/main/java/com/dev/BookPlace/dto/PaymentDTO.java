package com.dev.BookPlace.dto;

import com.dev.BookPlace.entities.Payment;
import com.dev.BookPlace.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PaymentDTO {
    private Long id;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentDate;
    private BigDecimal amount;

    public PaymentDTO(Payment entity) {
        id = entity.getId();
        paymentStatus = entity.getPaymentStatus();
        paymentDate = entity.getPaymentDate();
        amount = entity.getAmount();
    }

}
