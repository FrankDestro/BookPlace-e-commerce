package com.dev.BookPlace.entities.pagseguro.response;

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

    @Data
    public static class Customer {
        private String name;
        private String email;
        private String tax_id;
        private List<Phone> phones;
    }

    @Data
    public static class Phone {
        private String type;
        private String country;
        private String area;
        private String number;
    }

    @Data
    public static class Item {
        private String reference_id;
        private String name;
        private int quantity;
        private int unit_amount;
    }

    @Data
    public static class Shipping {
        private Address address;
    }

    @Data
    public static class Address {
        private String street;
        private String number;
        private String complement;
        private String locality;
        private String city;
        private String region_code;
        private String country;
        private String postal_code;
    }

    @Data
    public static class Charge {
        private String id;
        private String reference_id;
        private String status;
        private String created_at;
        private String description;
        private Amount amount;
        private PaymentResponse payment_response;
        private PaymentMethod payment_method;
        private List<Link> links;
    }

    @Data
    public static class Amount {
        private int value;
        private String currency;
        private Summary summary;
    }

    @Data
    public static class Summary {
        private int total;
        private int paid;
        private int refunded;
    }

    @Data
    public static class PaymentResponse {
        private String code;
        private String message;
    }

    @Data
    public static class PaymentMethod {
        private String type;
        private Boleto boleto;
    }

    @Data
    public static class Boleto {
        private String id;
        private String barcode;
        private String formatted_barcode;
        private String due_date;
        private InstructionLines instruction_lines;
        private Holder holder;
    }

    @Data
    public static class InstructionLines {
        private String line_1;
        private String line_2;
    }

    @Data
    public static class Holder {
        private String name;
        private String tax_id;
        private String email;
        private Address address;
    }

    @Data
    public static class Link {
        private String rel;
        private String href;
        private String media;
        private String type;
    }
}

