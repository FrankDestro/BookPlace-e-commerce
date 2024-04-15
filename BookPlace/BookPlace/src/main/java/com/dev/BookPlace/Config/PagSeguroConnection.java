package com.dev.BookPlace.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PagSeguroConnection {

    @Value("${security.pg.token}")
    private String accessToken;

    @Value("${security.pg.url}")
    private String urlOrderPg;

    private final RestTemplate restTemplate;

    public PagSeguroConnection(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> post(Object requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(urlOrderPg, HttpMethod.POST, requestEntity, String.class);
    }
}
