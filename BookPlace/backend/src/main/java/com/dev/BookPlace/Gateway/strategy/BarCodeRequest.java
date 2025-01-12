package com.dev.BookPlace.Gateway.strategy;

import com.dev.BookPlace.Gateway.integration.PagSeguroBarCodeClient;
import com.dev.BookPlace.Gateway.mappers.ChargeMapper;
import com.dev.BookPlace.Gateway.models.entities.Charge;
import com.dev.BookPlace.Gateway.request.BarCodeOrderRequest;
import com.dev.BookPlace.Gateway.request.PaymentOrderRequest;
import com.dev.BookPlace.Gateway.response.PagSeguroBarCodeResponse;
import com.dev.BookPlace.Gateway.services.BarCodeService;
import com.dev.BookPlace.Gateway.utils.Functions;
import com.dev.BookPlace.Gateway.utils.OrderDetailsService;
import com.dev.BookPlace.enums.PaymentMethod;
import com.dev.BookPlace.models.dto.OrderDTO;
import com.dev.BookPlace.models.entities.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BarCodeRequest implements PaymentStrategy{

    @Value("${PAGSEGURO_AUTH_TOKEN}")
    private String authorizationToken;
    private final Functions functions;
    private final OrderDetailsService orderDetailsService;
    private final PagSeguroBarCodeClient pagSeguroBarCodeClient;
    private final BarCodeService barCodeService;

    @Override
    public PaymentMethod getType() {
        return PaymentMethod.BARCODE;
    }

    @Override
    public OrderDTO processPayment(Order order) {

        String bearerToken = "Bearer " + authorizationToken;

        BarCodeOrderRequest barCodeOrderRequest = createBarCodeOrderRequest(order);
        PagSeguroBarCodeResponse barCodeResponse = pagSeguroBarCodeClient.createBarCodeOrder(bearerToken, barCodeOrderRequest);

        if (barCodeResponse != null && !barCodeResponse.getId().isEmpty()) {
            barCodeService.gravarOrderBarCodeRepository(order, barCodeResponse);
        } else {
            throw new RuntimeException("Error processing payment with BarCode.");
        }

        return  new OrderDTO(order);
    }

    private BarCodeOrderRequest createBarCodeOrderRequest(Order order) {
        BarCodeOrderRequest request = new BarCodeOrderRequest();
        PaymentOrderRequest commonRequest = orderDetailsService.createCommonOrderDetails(order);
        orderDetailsService.copyCommonOrderDetails(commonRequest, request);

        List<Charge> chargeList = new ArrayList<>();
        Charge charge = ChargeMapper.INSTANCE.orderToCharge(order, request, functions);
        chargeList.add(charge);
        request.setCharges(chargeList);
        return request;
    }

}

