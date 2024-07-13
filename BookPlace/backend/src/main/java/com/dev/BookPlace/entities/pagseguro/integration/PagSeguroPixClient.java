package com.dev.BookPlace.entities.pagseguro.integration;

import com.dev.BookPlace.entities.pagseguro.request.PixOrderRequest;
import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name = "pagseguro-pix", url = "https://sandbox.api.pagseguro.com")
public interface PagSeguroPixClient {

    @PostMapping("/orders")
    PagSeguroPixResponse createPixOrder(
            @RequestHeader("Authorization") String bearerToken,
            @RequestBody PixOrderRequest pixOrderRequest
    );
}