package com.dev.BookPlace.entities.pagSeguro.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Qrcode {
    private Amount amount;
    private String expiration_date;

}
