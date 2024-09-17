package com.dev.BookPlace.entities.pagseguro.integration;

import com.dev.BookPlace.entities.pagseguro.request.CardCreditOrderRequest;
import com.dev.BookPlace.entities.pagseguro.response.PagSeguroCreditCardResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name = "pagseguro-credit-card", url = "https://sandbox.api.pagseguro.com")
public interface PagSeguroCardClient {

    @PostMapping("/orders")
    PagSeguroCreditCardResponse createCreditCardOrder(
            @RequestHeader("Authorization") String bearerToken,
            @RequestBody CardCreditOrderRequest cardCreditOrderRequest
    );
}