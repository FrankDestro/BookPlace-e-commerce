package com.dev.BookPlace.entities.pagseguro.models.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Amount {

    @Column(name = "value_amount")
    private BigDecimal value;
    private String currency;
    @OneToOne(cascade = CascadeType.ALL)
    private Summary summary;
}
