package com.dev.BookPlace.entities.pagseguro.entities;

import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse;
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
    private String expiration_date;
    @Embedded
    private Amount amount;
    private String text;
    private List<String> arrangements;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Link> links;
}
