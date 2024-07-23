package com.dev.BookPlace.entities.pagseguro.request;

import com.dev.BookPlace.entities.pagseguro.entities.Charge;
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
