package com.dev.BookPlace.entities.pagseguro.entities;

import com.dev.BookPlace.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Charge {
    private String reference_id; // ajustado para o formato snake_case
    private String description;
    private Amount amount;
    private PaymentMethod payment_method; // ajustado para o formato snake_case
}
