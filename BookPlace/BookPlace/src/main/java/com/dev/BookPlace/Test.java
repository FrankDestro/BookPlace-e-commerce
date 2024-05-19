package com.dev.BookPlace;

import com.dev.BookPlace.enums.PaymentMethod;
import com.dev.BookPlace.integration.PagSeguroConnection;
import com.dev.BookPlace.services.PagSeguroOrderBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.net.http.HttpResponse;

public class Test {

    public static void main(String[] args) throws JsonProcessingException {

        PaymentMethod paymentMethod = PaymentMethod.PIX;

        PagSeguroOrderBuilder od = new PagSeguroOrderBuilder();
        String jsonBuildResponse = od.buildOrderRequest();

        PagSeguroConnection p = new PagSeguroConnection();
        HttpResponse result = p.sendPostRequest(jsonBuildResponse);

        System.out.println(result.body());
        System.out.println(result.statusCode());

    }
}
