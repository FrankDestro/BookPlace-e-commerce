package com.dev.BookPlace.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "address")
    private Set<Order> orders = new HashSet<>();

    public Address(Long id) {
        this.id = id;
    }
}
