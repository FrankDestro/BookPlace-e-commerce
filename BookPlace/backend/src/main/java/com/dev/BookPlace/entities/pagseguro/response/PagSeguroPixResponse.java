package com.dev.BookPlace.entities.pagseguro.response;

import com.dev.BookPlace.entities.pagseguro.entities.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

//@Data
//public class PagSeguroPixResponse {
//    private String id;
//    private String created_at;
//    private Customer customer;
//    private List<Item> items;
//    private Shipping shipping;
//    private List<QrCode> qr_codes;
//    private List<String> notification_urls;
//    private List<Link> links;
//}

@Data
@Entity
@Table(name = "tb_pix_response_details_pagseguro")
public class PagSeguroPixResponse {

    @Id
    private String id;
    private String created_at;
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Item> items;
    @OneToOne(cascade = CascadeType.ALL)
    private Shipping shipping;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_provider_details_id")
    private List<QrCode> qr_codes;
    @ElementCollection
    private List<String> notification_urls;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Link> links;

}
