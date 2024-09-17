package com.dev.BookPlace.entities.pagseguro.models.entities;

import lombok.*;

import com.dev.BookPlace.entities.pagseguro.models.entities.Card;

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
