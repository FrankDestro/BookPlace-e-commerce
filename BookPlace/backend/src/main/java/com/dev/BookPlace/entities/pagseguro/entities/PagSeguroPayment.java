//package com.dev.BookPlace.entities.pagseguro.entities;
//
//import com.dev.BookPlace.entities.Payment;
//import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//
//@Entity
//public class PagSeguroPayment  {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String createdAt;
//    private String providerTransactionId;
//    private PagSeguroPixResponse.Customer customer;
//    private List<PagSeguroPixResponse.Item> items;
//    private PagSeguroPixResponse.Shipping shipping;
//    private List<PagSeguroPixResponse.QRCode> qrCodes;
//    private List<PagSeguroPixResponse.Link> links;
//
//    @OneToOne
//    @JoinColumn(name = "payment_id")
//    private Payment payment;
//}
