package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.dto.OrderDTO;
import com.dev.BookPlace.dto.OrderItemDTO;
import com.dev.BookPlace.entities.*;
import com.dev.BookPlace.entities.pagseguro.entities.Amount;
import com.dev.BookPlace.entities.pagseguro.entities.Charge;
import com.dev.BookPlace.entities.pagseguro.entities.Customer;
import com.dev.BookPlace.entities.pagseguro.entities.QrCode;
import com.dev.BookPlace.entities.pagseguro.integration.PagSeguroBarCodeClient;
import com.dev.BookPlace.entities.pagseguro.integration.PagSeguroPixClient;
import com.dev.BookPlace.entities.pagseguro.mappers.*;
import com.dev.BookPlace.entities.pagseguro.repository.PaymentProviderPixDetailsRepository;
import com.dev.BookPlace.entities.pagseguro.request.BarCodeOrderRequest;
import com.dev.BookPlace.entities.pagseguro.request.PaymentOrderRequest;
import com.dev.BookPlace.entities.pagseguro.request.PixOrderRequest;
import com.dev.BookPlace.entities.pagseguro.response.PagSeguroBarCodeResponse;
import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse;
import com.dev.BookPlace.entities.pagseguro.response.PaymentProviderPixDetails;
import com.dev.BookPlace.entities.pagseguro.utils.Functions;
import com.dev.BookPlace.enums.OrderStatus;
import com.dev.BookPlace.enums.PaymentStatus;
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
    private final UserService userService;
    private final PagSeguroPixClient pagSeguroPixClient;
    private final PaymentRepository paymentRepository;
    private final PagSeguroBarCodeClient pagSeguroBarCodeClient;
    private final CustomerMapper customerMapper;
    private final PhonesMapper phonesMapper;
    private final ShippingMapper shippingMapper;
    private final ItemsMapper itemsMapper;
    private final Functions functions;

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
                System.out.println("result " + pixResponse);
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
                System.out.println("result " + barCodeResponse);
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
        request.setCustomer(commonRequest.getCustomer());
        request.setItems(commonRequest.getItems());
        request.setNotification_urls(commonRequest.getNotification_urls());
        request.setShipping(commonRequest.getShipping());
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
        request.setCustomer(commonRequest.getCustomer());
        request.setItems(commonRequest.getItems());
        request.setNotification_urls(commonRequest.getNotification_urls());
        request.setShipping(commonRequest.getShipping());

        List<Charge> chargeList = new ArrayList<>();

        Charge charge = new Charge();
        charge.setReference_id("referencia de cobrança");
        charge.setDescription("descrição da cobranca");
        Amount amount = new Amount();
        amount.setCurrency("BRL");
        amount.setValue(functions.converterValueDoubleToBigDecimalNoDecimal(order.getTotalSum()));
        charge.setAmount(amount);
        charge.getPayment_method().setType("BOLETO");
        Instant now = Instant.now();
        Instant dueDateInstant = now.plus(Duration.ofDays(3));

        System.out.println("data " + functions.getFormattedDate(dueDateInstant));

        charge.getPayment_method().getBoleto().setDue_date(functions.getFormattedDate(dueDateInstant));

        charge.getPayment_method().getBoleto().getInstruction_lines().setLine_1("Pagamento processado para DESC Fatura");
        charge.getPayment_method().getBoleto().getInstruction_lines().setLine_2("Via PagSeguro");
        charge.getPayment_method().getBoleto().getHolder().setName(order.getClient().getFullName());
        charge.getPayment_method().getBoleto().getHolder().setEmail(order.getClient().getEmail());
        charge.getPayment_method().getBoleto().getHolder().setTax_id(order.getClient().getCpf());
        charge.getPayment_method().getBoleto().getHolder().setAddress(request.getShipping().getAddress());
        chargeList.add(charge);
        request.setCharges(chargeList);

        return request;
    }
}
