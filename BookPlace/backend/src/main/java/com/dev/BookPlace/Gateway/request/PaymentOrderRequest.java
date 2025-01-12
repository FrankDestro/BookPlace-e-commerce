package com.dev.BookPlace.Gateway.request;

import com.dev.BookPlace.Gateway.models.entities.Customer;
import com.dev.BookPlace.Gateway.models.entities.Item;
import com.dev.BookPlace.Gateway.models.entities.Shipping;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PaymentOrderRequest {

    private String reference_id;
    private Customer customer;
    private List<Item> items;
    private Shipping shipping;
    private List<String> notification_urls;
}
