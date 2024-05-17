package com.dev.BookPlace.entities.pagSeguro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String name;
    private int quantity;
    private int unit_amount;

}
