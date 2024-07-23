package com.dev.BookPlace.entities.pagseguro.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentMethod {
    private String type;
    private Boleto boleto = new Boleto();

}
