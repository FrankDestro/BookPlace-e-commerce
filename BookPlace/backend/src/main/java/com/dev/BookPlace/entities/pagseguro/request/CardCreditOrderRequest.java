package com.dev.BookPlace.entities.pagseguro.request;

import com.dev.BookPlace.entities.pagseguro.models.entities.Card;
import com.dev.BookPlace.entities.pagseguro.models.entities.Charge;
import com.dev.BookPlace.entities.pagseguro.models.entities.QrCode;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CardCreditOrderRequest extends PaymentOrderRequest {
    private List<Charge> charges;
}


