package com.dev.BookPlace.models.entities;

import com.dev.BookPlace.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentDate;
    private BigDecimal amount;

    @OneToOne
    @MapsId
    private Order order;

}
