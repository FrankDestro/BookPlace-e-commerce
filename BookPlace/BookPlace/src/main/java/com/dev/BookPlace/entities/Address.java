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
    private String address;
    private Integer number;
    private String addressDetails;
    private String neighborhood;
    private String zip;
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
