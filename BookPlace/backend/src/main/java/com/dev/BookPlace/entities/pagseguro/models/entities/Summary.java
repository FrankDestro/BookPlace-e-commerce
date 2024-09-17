package com.dev.BookPlace.entities.pagseguro.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_summary_pagseguro")
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_summary;
    private int total;
    private int paid;
    private int refunded;
}
