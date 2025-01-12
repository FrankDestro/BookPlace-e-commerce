package com.dev.BookPlace.Gateway.integration;

import com.dev.BookPlace.Gateway.request.BarCodeOrderRequest;
import com.dev.BookPlace.Gateway.response.PagSeguroBarCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(name = "pagseguro-barcode", url = "https://sandbox.api.pagseguro.com")
public interface PagSeguroBarCodeClient {

    @PostMapping("/orders")
    PagSeguroBarCodeResponse createBarCodeOrder(
            @RequestHeader("Authorization") String bearerToken,
            @RequestBody BarCodeOrderRequest barCodeOrderRequest
    );
}