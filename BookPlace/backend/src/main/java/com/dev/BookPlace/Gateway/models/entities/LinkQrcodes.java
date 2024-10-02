package com.dev.BookPlace.Gateway.models.entities;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_links_pagseguro_qrcode")
public class LinkQrcodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rel;
    private String href;
    private String media;
    private String type;
}

