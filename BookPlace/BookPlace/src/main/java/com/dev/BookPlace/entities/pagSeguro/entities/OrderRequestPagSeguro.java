package com.dev.BookPlace.entities.pagSeguro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestPagSeguro {

    private String reference_id;
    private Customer customer;
    private List<Phone> phones;
    private List<Item> items;
    private List<Qrcode> qr_codes;
    private Shipping shipping;
    private List<String> notificationUrls;

}
