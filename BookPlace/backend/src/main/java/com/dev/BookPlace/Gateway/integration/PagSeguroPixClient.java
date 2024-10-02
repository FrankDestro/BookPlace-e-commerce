package com.dev.BookPlace.Gateway.integration;

import com.dev.BookPlace.Gateway.request.PixOrderRequest;
import com.dev.BookPlace.Gateway.response.PagSeguroPixResponse;
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