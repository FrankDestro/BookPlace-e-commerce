package com.dev.BookPlace.integration;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class PagSeguroConnection {

    String url = "https://sandbox.api.pagseguro.com/orders";
    String autorizationToken = "CF9A47FA06EB427DAB432E55BB067B98";

    public HttpResponse<String> sendPostRequest(String requestBody) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer "+autorizationToken)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException |
                 InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }
}
