package com.dev.BookPlace.entities.pagseguro.response;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
public class PagSeguroPixResponse {
    private String id;
    private String created_at;
    private Customer customer;
    private List<Item> items;
    private Shipping shipping;
    private List<QRCode> qr_codes;
    private List<String> notification_urls;
    private List<Link> links;

    @Data
    public class Customer {
        private String name;
        private String email;
        private String tax_id;
        private List<Phone> phones;

        @Data
        public static class Phone {
            private String type;
            private String country;
            private String area;
            private String number;
        }
    }

    @Data
    public static class Item {
        private String name;
        private int quantity;
        private int unit_amount;
    }

    @Data
    public static class Shipping {
        private Address address;

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
    }

    @Data
    public static class QRCode {
        private String id;
        private String expiration_date;
        private Amount amount;
        private String text;
        private List<String> arrangements;
        private List<Link> links;

        @Data
        public static class Amount {
            private int value;
        }
    }

    @Data
    public static class Link {
        private String rel;
        private String href;
        private String media;
        private String type;
    }
}
