package com.dev.BookPlace.entities.pagseguro.response;

import jakarta.persistence.*;
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
    @Entity
    public class Customer {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String email;
        private String tax_id;
        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "customer_id")
        private List<Phone> phones;

        @Data
        @Entity
        @Table(name = "tb_phone_payment_provider_details")
        public static class Phone {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
            private String type;
            private String country;
            private String area;
            private String number;
        }
    }

    @Data
    @Entity
    @Table(name = "tb_itens_payment_provider_details")
    public static class Item {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private int quantity;
        private int unit_amount;
    }

    @Data
    @Entity
    @Table(name = "tb_shipping_payment_provider_details")
    public static class Shipping {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Embedded
        private Address address;

        @Data
        @Embeddable
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
    @Entity
    @Table(name = "tb_qrcode_payment_provider_details")
    public static class QRCode {
        @Id
        private String id;
        private String expiration_date;
        @Embedded
        private Amount amount;
        private String text;
        private List<String> arrangements;
        @OneToMany(cascade = CascadeType.ALL)
        private List<Link> links;

        @Data
        @Embeddable
        public static class Amount {
            private int value;
        }
    }

    @Data
    @Entity
    @Table(name = "tb_links_payment_provider_details")
    public static class Link {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String rel;
        private String href;
        private String media;
        private String type;
    }
}
