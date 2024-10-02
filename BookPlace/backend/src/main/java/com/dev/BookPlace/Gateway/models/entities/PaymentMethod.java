package com.dev.BookPlace.Gateway.models.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentMethod {
    private String type;
    private Boleto boleto = new Boleto();

    //Novo para cartão de credito.
    private Integer installments;
    private Boolean capture;
    private  Card card = new Card();
}
