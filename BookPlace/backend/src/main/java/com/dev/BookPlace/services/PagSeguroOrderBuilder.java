package com.dev.BookPlace.services;

import com.dev.BookPlace.entities.bookplace.entities.Order;
import com.dev.BookPlace.entities.pagSeguro.entities.*;
import com.dev.BookPlace.enums.PaymentMethod;
import com.dev.BookPlace.integration.PagSeguroConnection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class PagSeguroOrderBuilder {

    public String buildOrderRequest() throws JsonProcessingException {

        OrderRequestPagSeguro od = new OrderRequestPagSeguro();

        String reference_id = "ex-00001";
        od.setReference_id(reference_id);

        Customer customer = new Customer();
        customer.setName("Jose da Silva");
        customer.setEmail("email@test.com");
        customer.setTax_id("12345678909");
        od.setCustomer(customer);

        List<Phone> phones = new ArrayList<>();
        Phone phone = new Phone();
        phone.setId(1L);
        phone.setCountry("55");
        phone.setArea("11");
        phone.setNumber("999999999");
        phone.setType("MOBILE");
        phones.add(phone);
        od.setPhones(phones);

        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setName("nome do item");
        item.setQuantity(2);
        item.setUnit_amount(100);
        items.add(item);
        od.setItems(items);

        List<Qrcode> qr_codes = new ArrayList<>();
        Qrcode qrCode = new Qrcode();
        Amount amount = new Amount();
        amount.setValue(200);
        qrCode.setAmount(amount);
        qrCode.setExpiration_date("2024-05-17T20:15:59-03:00");
        qr_codes.add(qrCode);
        od.setQr_codes(qr_codes);

        AddresssShipping address = new AddresssShipping();
        address.setId(1L);
        address.setStreet("Avenida Brigadeiro Faria Lima");
        address.setNumber("1384");
        address.setComplement("apto 12");

        address.setLocality("pinheiros");
        address.setCity("são paulo");
        address.setRegion_code("SP");
        address.setCountry("BRA");
        address.setPostal_code("01452002");
        Shipping shipping = new Shipping();
        shipping.setAddress(address);
        od.setShipping(shipping);

        List<String> listNotificationUrl = new ArrayList<>();
        listNotificationUrl.add("https://meusite.com/notificacoes");
        od.setNotificationUrls(listNotificationUrl);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonOd = objectMapper.writeValueAsString(od);

        return jsonOd;
    }
}
