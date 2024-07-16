package com.dev.BookPlace.entities.pagseguro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Charge {
    private String reference_id;
    private String description;
    private Amount amount;
    private PaymentMethod payment_method = new PaymentMethod();

}
