package com.dev.BookPlace.entities.pagSeguro.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Phone {
    private Long id;
    private String country;
    private String area;
    private String number;
    private String  type;

}
