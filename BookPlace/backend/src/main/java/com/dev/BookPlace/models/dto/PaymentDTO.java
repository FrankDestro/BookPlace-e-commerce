package com.dev.BookPlace.models.dto;

import com.dev.BookPlace.Gateway.response.PagSeguroPixResponse;
import com.dev.BookPlace.models.entities.Payment;
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
    private Long id_payment;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentDate;
    private BigDecimal amount;
    private PagSeguroPixResponse pixResponse;

    public PaymentDTO(Payment entity) {
        id_payment = entity.getId_payment();
        paymentStatus = entity.getPaymentStatus();
        paymentDate = entity.getPaymentDate();
        amount = entity.getAmount();
        pixResponse = entity.getPixResponse();
    }
}
