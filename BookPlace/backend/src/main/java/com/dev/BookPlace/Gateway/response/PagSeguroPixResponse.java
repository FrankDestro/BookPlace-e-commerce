package com.dev.BookPlace.Gateway.response;
import com.dev.BookPlace.Gateway.models.entities.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_pix_response_details_pagseguro")
public class PagSeguroPixResponse {

    @Id
    private String id;

    @Column(name = "created_at")
    private String created_at;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "items_id")
    private List<Item> items;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "shipping_id")
    private Shipping shipping;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pix_response_id")
    private List<QrCode> qr_codes;

    @ElementCollection
    @CollectionTable(name = "notification_urls", joinColumns = @JoinColumn(name = "pix_response_id"))
    @Column(name = "url")
    private List<String> notification_urls;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @CollectionTable(name = "response_links", joinColumns = @JoinColumn(name = "pix_response_id"))
    @Column(name = "link")
    private List<Link> links;
}
