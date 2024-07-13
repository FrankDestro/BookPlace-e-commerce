package com.dev.BookPlace;

import com.dev.BookPlace.entities.Address;
import com.dev.BookPlace.entities.User;
import com.dev.BookPlace.entities.pagseguro.entities.Shipping;
import com.dev.BookPlace.entities.pagseguro.request.PixOrderRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) throws JsonProcessingException {

//        PaymentMethod paymentMethod = PaymentMethod.PIX;
//
//        PagSeguroOrderBuilder od = new PagSeguroOrderBuilder();
//        String jsonBuildResponse = od.buildOrderRequest();
//
//        PagSeguroConnection p = new PagSeguroConnection();
//        HttpResponse result = p.sendPostRequest(jsonBuildResponse);
//
//        System.out.println(result.body());
//        System.out.println(result.statusCode());

//        try {
//            // Configure o ObjectMapper
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//            objectMapper.registerModule(new JavaTimeModule());
//            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//
//            // Crie um exemplo de PixOrderRequest
//            User user = new User();
//            user.setBirthDate(LocalDate.of(1990, 1, 1));
//            user.setEmail("teste@gmail.com");
//
//            Address address = new Address();
//            address.setUser(user);
//
//            Shipping shipping = new Shipping();
//            shipping.setAddress(address);
//
//            PixOrderRequest pixOrderRequest = new PixOrderRequest();
//            pixOrderRequest.setShipping(shipping);
//
//            // Converter para JSON
//            String jsonOd = objectMapper.writeValueAsString(pixOrderRequest);
//            System.out.println(jsonOd);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

