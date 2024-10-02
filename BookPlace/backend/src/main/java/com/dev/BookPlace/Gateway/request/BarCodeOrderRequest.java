package com.dev.BookPlace.Gateway.request;

import com.dev.BookPlace.Gateway.models.entities.Charge;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BarCodeOrderRequest extends PaymentOrderRequest{
    private List<Charge> charges;
}
