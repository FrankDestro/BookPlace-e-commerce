package com.dev.BookPlace.Gateway.strategy.factory;

import com.dev.BookPlace.Gateway.strategy.BarcodePaymentStrategy;
import com.dev.BookPlace.Gateway.strategy.CreditCardPaymentStrategy;
import com.dev.BookPlace.Gateway.strategy.PaymentStrategy;
import com.dev.BookPlace.Gateway.strategy.PixPaymentStrategy;

import static com.dev.BookPlace.enums.PaymentMethod.*;

public class PaymentStrategyFactory {

    public static PaymentStrategy getPaymentStrategy(String paymentMethod) {
        switch (paymentMethod.toLowerCase()) {
            case PIX -> {
                return new PixPaymentStrategy();
            }
            case BARCODE -> {
                return new BarcodePaymentStrategy();
            }
            case CREDIT_CARD -> {
                return new CreditCardPaymentStrategy();
            }
            default -> throw new IllegalArgumentException("unknown method payment");
        }
    }
}
