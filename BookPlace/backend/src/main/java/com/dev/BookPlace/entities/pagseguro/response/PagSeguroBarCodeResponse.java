package com.dev.BookPlace.entities.pagseguro.response;

import com.dev.BookPlace.entities.pagseguro.models.entities.*;
import lombok.Data;

import java.util.List;

@Data
public class PagSeguroBarCodeResponse {
    private String id;
    private String reference_id;
    private String created_at;
    private Customer customer;
    private List<Item> items;
    private Shipping shipping;
    private List<Charge> charges;
    private List<String> notification_urls;
    private List<Link> links;
}

