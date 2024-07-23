package com.dev.BookPlace.entities.pagseguro.entities;

import com.dev.BookPlace.entities.pagseguro.response.PagSeguroBarCodeResponse;
import jakarta.persistence.CascadeType;
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

    private BigDecimal value;
    private String currency;
    @OneToOne(cascade = CascadeType.ALL)
    private Summary summary;
}
