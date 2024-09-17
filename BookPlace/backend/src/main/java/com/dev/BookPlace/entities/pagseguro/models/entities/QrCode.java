package com.dev.BookPlace.entities.pagseguro.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "tb_qrcode_pagseguro")
public class QrCode {
    @Id
    private String id;

    @Column(name = "expiration_date")
    private String expiration_date;

    @Embedded
    private Amount amount;

    private String text;

    @ElementCollection
    @CollectionTable(name = "qr_code_arrangements", joinColumns = @JoinColumn(name = "qr_code_id"))
    @Column(name = "arrangement")
    private List<String> arrangements;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "qr_code_id")
    private List<LinkQrcodes> links;
}
