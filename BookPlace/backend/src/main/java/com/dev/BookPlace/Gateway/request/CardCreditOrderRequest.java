package com.dev.BookPlace.Gateway.request;

import com.dev.BookPlace.Gateway.models.entities.Charge;
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


