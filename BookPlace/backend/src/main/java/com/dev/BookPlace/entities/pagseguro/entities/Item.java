package com.dev.BookPlace.entities.pagseguro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Item {

    private String reference_id; // ajustado para o formato snake_case
    private String name;
    private Integer quantity;
    private BigDecimal unit_amount; // ajustado para o formato snake_case
}
