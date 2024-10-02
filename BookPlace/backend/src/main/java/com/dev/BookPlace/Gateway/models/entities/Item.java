package com.dev.BookPlace.Gateway.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_itens_pagseguro")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_item;
    private String reference_id;
    private String name;
    private Integer quantity;
    private BigDecimal unit_amount;

}
