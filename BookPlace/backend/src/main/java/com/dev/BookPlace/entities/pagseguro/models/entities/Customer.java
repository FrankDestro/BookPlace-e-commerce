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
@Table(name = "tb_customer_pagseguro")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_customer;
    private String name;
    private String email;
    private String tax_id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_pagseguro_id")
    private List<PhonePag> phones;
}
