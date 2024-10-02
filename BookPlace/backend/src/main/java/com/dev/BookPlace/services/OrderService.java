package com.dev.BookPlace.services;

import com.dev.BookPlace.Gateway.mappers.*;
import com.dev.BookPlace.Gateway.models.entities.*;
import com.dev.BookPlace.models.dto.AddressDTO;
import com.dev.BookPlace.models.dto.OrderDTO;
import com.dev.BookPlace.models.dto.OrderItemDTO;
import com.dev.BookPlace.Gateway.integration.PagSeguroBarCodeClient;
import com.dev.BookPlace.Gateway.integration.PagSeguroCardClient;
import com.dev.BookPlace.Gateway.integration.PagSeguroPixClient;
import com.dev.BookPlace.Gateway.repositories.PagSeguroPixResponseRepository;
import com.dev.BookPlace.Gateway.request.BarCodeOrderRequest;
import com.dev.BookPlace.Gateway.request.PaymentOrderRequest;
import com.dev.BookPlace.Gateway.request.PixOrderRequest;
import com.dev.BookPlace.Gateway.response.PagSeguroBarCodeResponse;
import com.dev.BookPlace.Gateway.response.PagSeguroCreditCardResponse;
import com.dev.BookPlace.Gateway.response.PagSeguroPixResponse;
import com.dev.BookPlace.Gateway.utils.Functions;
import com.dev.BookPlace.enums.OrderStatus;
import com.dev.BookPlace.enums.PaymentStatus;
import com.dev.BookPlace.models.entities.*;
import com.dev.BookPlace.repositories.*;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    private final AddressRepository addressRepository;
    private final PaymentRepository paymentRepository;
    private final PagSeguroPixResponseRepository pagSeguroPixResponseRepository;

    private final PagSeguroPixClient pagSeguroPixClient;
    private final PagSeguroBarCodeClient pagSeguroBarCodeClient;
    private final PagSeguroCardClient pagSeguroCardClient;

    private final Functions functions;
    private final UserService userService;

    private final CustomerMapper customerMapper;
    private final PhonesMapper phonesMapper;
    private final ShippingMapper shippingMapper;
    private final ItemsMapper itemsMapper;
    private final PixResponseMapper pixResponseMapper;
    private final QrCodeMapper qrCodeMapper;
    private final LinksMapper linksMapper;
    private final AmountMapper amountMapper;

    @Value("${PAGSEGURO_AUTH_TOKEN}")
    private String authorizationToken;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO recordOder(OrderDTO dto) throws JsonProcessingException {

        Order order = getOrder(dto);
        String bearerToken = "Bearer " + authorizationToken;

        switch (order.getPaymentMethod()) {
            case PIX -> {
                PixOrderRequest pixOrderRequest = createPixOrderRequest(order);
                PagSeguroPixResponse pixResponse = pagSeguroPixClient.createPixOrder(bearerToken, pixOrderRequest);
                if (pixResponse != null && !pixResponse.getId().isEmpty()) {
                    gravarOrderPixRepository(order, pixResponse);
                } else {
                    throw new RuntimeException("Error processing payment with Pix.");
                }
                return new OrderDTO(order);
            }
            case BARCODE -> {
                BarCodeOrderRequest barCodeOrderRequest = createBarCodeOrderRequest(order);
                PagSeguroBarCodeResponse barCodeResponse = pagSeguroBarCodeClient.createBarCodeOrder(bearerToken, barCodeOrderRequest);
                if (barCodeResponse != null && !barCodeResponse.getId().isEmpty()) {
                    gravarOrderBarCodeRepository(order, barCodeResponse);
                } else {
                    throw new RuntimeException("Error processing payment with BarCode.");
                }
            }
        }
        return new OrderDTO(order);
    }

    private Order getOrder(OrderDTO dto) {
        Order order = new Order();
        order.setPaymentMethod(dto.getPaymentMethod());
        User user = userService.authenticated();
        order.setClient(user);
        AddressDTO address = dto.getAddress();
        Address addressShipping = addressRepository.getReferenceById(address.getId());
        order.setAddress(addressShipping);

        double total = 0.0;

        for (OrderItemDTO itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            double subtotal = product.getPrice() * itemDto.getQuantity();
            total += subtotal;
            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice(), subtotal, product.getName());
            order.getItems().add(item);
        }
        order.setTotalSum(total);
        return order;
    }

    private void gravarOrderPixRepository(Order order, PagSeguroPixResponse pixResponse) {
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());
        Payment payment = createPayment(order);

        PagSeguroPixResponse result = pixResponseMapper.toPagSeguroPixResponse(pixResponse);

        List<QrCode> listQrCode = qrCodeMapper.toQrcodeCompleted(pixResponse.getQr_codes());
        List<String> listArrangements = qrCodeMapper.toListArrangements(pixResponse.getQr_codes().getLast().getArrangements());
        List<LinkQrcodes> linksQrcode = linksMapper.toListLinksQrcode(pixResponse.getQr_codes().get(0).getLinks());
        List<Link> linksOrder = linksMapper.toListLinks(pixResponse.getLinks());
        Amount amount = amountMapper.toAmountCompleted(pixResponse.getQr_codes().getLast().getAmount());

        listQrCode.get(0).setLinks(linksQrcode);
        listQrCode.get(0).setArrangements(listArrangements);

        result.setQr_codes(listQrCode);
        result.getQr_codes().get(0).setAmount(amount);
        result.setLinks(linksOrder);

        pagSeguroPixResponseRepository.save(result);
        paymentRepository.save(payment);

    }

    private void gravarOrderBarCodeRepository(Order order, PagSeguroBarCodeResponse barCodeResponse) {
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());
        Payment payment = createPayment(order);
        paymentRepository.save(payment);
    }

    private void gravarOrderCreditCardRepository(Order order, PagSeguroCreditCardResponse pagSeguroCreditCardResponse) {
    }

    private Payment createPayment(Order order) {
        Payment payment = new Payment();
        payment.setPaymentStatus(PaymentStatus.WAITING_PAYMENT);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setAmount(BigDecimal.valueOf(200));
        payment.setOrder(order);
        return payment;
    }

    private PaymentOrderRequest createCommonOrderDetails(Order order) {
        PaymentOrderRequest request = new PaymentOrderRequest();

        Customer customer;
        customer = customerMapper.orderClientToPagSeguroCustomer(order);
        customer.setPhones(phonesMapper.orderPhonesToPagSeguroPhones(order.getClient().getPhones()));
        request.setCustomer(customer);
        request.setItems(itemsMapper.orderItemsToItems(order.getItems()));

        List<String> listNotificationUrl = new ArrayList<>();
        listNotificationUrl.add("https://meusite.com/notificacoes");
        request.setNotification_urls(listNotificationUrl);

        request.setShipping(shippingMapper.orderAddressToPagSeguroShipping(order.getAddress()));
        return request;
    }


    private PixOrderRequest createPixOrderRequest(Order order) {
        PixOrderRequest request = new PixOrderRequest();
        PaymentOrderRequest commonRequest = createCommonOrderDetails(order);
        copyCommonOrderDetails(commonRequest, request);

        List<QrCode> qr_codes = new ArrayList<>();
        QrCode qrCode = new QrCode();
        Amount amount = new Amount();
        amount.setValue(functions.converterValueDoubleToBigDecimalNoDecimal(order.getTotalSum()));
        qrCode.setAmount(amount);
        Instant expirationDate = Instant.now().plus(Duration.ofMinutes(15));
        qrCode.setExpiration_date(expirationDate.toString());
        qr_codes.add(qrCode);
        request.setQr_codes(qr_codes);

        return request;
    }

    private BarCodeOrderRequest createBarCodeOrderRequest(Order order) {
        BarCodeOrderRequest request = new BarCodeOrderRequest();
        PaymentOrderRequest commonRequest = createCommonOrderDetails(order);
        copyCommonOrderDetails(commonRequest, request);

        List<Charge> chargeList = new ArrayList<>();
        Charge charge = ChargeMapper.INSTANCE.orderToCharge(order, request, functions);
        chargeList.add(charge);
        request.setCharges(chargeList);
        return request;
    }

    public void copyCommonOrderDetails(PaymentOrderRequest commonRequest, PaymentOrderRequest specificRequest) {
        specificRequest.setCustomer(commonRequest.getCustomer());
        specificRequest.setItems(commonRequest.getItems());
        specificRequest.setNotification_urls(commonRequest.getNotification_urls());
        specificRequest.setShipping(commonRequest.getShipping());
    }
}
