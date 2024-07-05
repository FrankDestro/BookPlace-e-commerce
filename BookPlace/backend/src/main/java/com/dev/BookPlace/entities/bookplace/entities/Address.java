package com.dev.BookPlace.entities.bookplace.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "tb_address")
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    private String complement;
    private String locality;
    private String city;
    private String regionCode;
    private String country;
    private String postalCode;
    private Boolean main;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address(Long id) {
        this.id = id;
    }
}
