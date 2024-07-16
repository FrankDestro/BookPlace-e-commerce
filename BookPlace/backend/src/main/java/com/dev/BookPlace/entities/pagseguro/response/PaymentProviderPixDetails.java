package com.dev.BookPlace.entities.pagseguro.response;

import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse.Customer;
import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse.Item;
import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse.QRCode;
import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse.Shipping;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_PaymentProviderDetails")
public class PaymentProviderPixDetails {
    @Id
    private String id;
    private String created_at;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    @OneToMany
    private List<Item> items;
    @OneToOne(cascade = CascadeType.ALL)
    private Shipping shipping;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_provider_details_id_qrcode")
    private List<QRCode> qr_codes;

    @ElementCollection
    private List<String> notification_urls;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PagSeguroPixResponse.Link> links;

}
