package com.dev.BookPlace.entities.pagseguro.request;

import com.dev.BookPlace.entities.pagseguro.entities.Customer;
import com.dev.BookPlace.entities.pagseguro.entities.Item;
import com.dev.BookPlace.entities.pagseguro.entities.Shipping;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PaymentOrderRequest {

    private String reference_id;
    private Customer customer;
    private List<Item> items;
    private Shipping shipping;
    private List<String> notification_urls;
}
