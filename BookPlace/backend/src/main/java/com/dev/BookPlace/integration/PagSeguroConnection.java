package com.dev.BookPlace.integration;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Key;

@Component
public class PagSeguroConnection {

    String url = "https://sandbox.api.pagseguro.com/orders";
    String authorizationToken = System.getenv("PAGSEGURO_AUTH_TOKEN");

    public HttpResponse<String> sendPostRequest(String requestBody) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer "+authorizationToken)
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
