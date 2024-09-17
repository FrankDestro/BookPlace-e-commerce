package com.dev.BookPlace.entities.pagseguro.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_sipping_pagseguro")
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_shipping;
    @Embedded
    private AddressPag address = new AddressPag();

}
