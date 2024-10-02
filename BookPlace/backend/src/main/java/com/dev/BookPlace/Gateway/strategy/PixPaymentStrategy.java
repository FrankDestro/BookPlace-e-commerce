package com.dev.BookPlace.Gateway.strategy;

import com.dev.BookPlace.Gateway.integration.PagSeguroBarCodeClient;
import com.dev.BookPlace.Gateway.integration.PagSeguroCardClient;
import com.dev.BookPlace.Gateway.integration.PagSeguroPixClient;
import com.dev.BookPlace.Gateway.mappers.*;
import com.dev.BookPlace.Gateway.models.entities.*;
import com.dev.BookPlace.Gateway.repositories.PagSeguroPixResponseRepository;
import com.dev.BookPlace.Gateway.request.PaymentOrderRequest;
import com.dev.BookPlace.Gateway.request.PixOrderRequest;
import com.dev.BookPlace.Gateway.response.PagSeguroPixResponse;
import com.dev.BookPlace.Gateway.utils.Functions;
import com.dev.BookPlace.enums.OrderStatus;
import com.dev.BookPlace.enums.PaymentStatus;
import com.dev.BookPlace.models.dto.OrderDTO;
import com.dev.BookPlace.models.entities.Order;
import com.dev.BookPlace.models.entities.Payment;
import com.dev.BookPlace.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PixPaymentStrategy implements PaymentStrategy{

    @Value("${PAGSEGURO_AUTH_TOKEN}")
    private String authorizationToken;

    private final OrderRepository repository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    private final AddressRepository addressRepository;
    private final PaymentRepository paymentRepository;
    private final PagSeguroPixResponseRepository pagSeguroPixResponseRepository;

    private final PagSeguroPixClient pagSeguroPixClient;


    private final Functions functions;

    private final CustomerMapper customerMapper;
    private final PhonesMapper phonesMapper;
    private final ShippingMapper shippingMapper;
    private final ItemsMapper itemsMapper;
    private final PixResponseMapper pixResponseMapper;
    private final QrCodeMapper qrCodeMapper;
    private final LinksMapper linksMapper;
    private final AmountMapper amountMapper;

    @Override
    public OrderDTO processPayment(Order order) {

        String bearerToken = "Bearer " + authorizationToken;

        // Chamando API Payment
        PixOrderRequest pixOrderRequest = createPixOrderRequest(order);
        PagSeguroPixResponse pixResponse = pagSeguroPixClient.createPixOrder(bearerToken, pixOrderRequest);

        if (pixResponse != null && !pixResponse.getId().isEmpty()) {
            gravarOrderPixRepository(order, pixResponse);
        } else {
            throw new RuntimeException("Error processing payment with Pix.");
        }
        return new OrderDTO(order);
    }


    // GRAVAR OS DADOS DA API DE PAGAMENTO NO BANCO DE DADOS
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

    // CRIAR PAGAMENTO DO ORDER
    private Payment createPayment(Order order) {
        Payment payment = new Payment();
        payment.setPaymentStatus(PaymentStatus.WAITING_PAYMENT);
        payment.setPaymentDate(LocalDateTime.now());
        payment.setAmount(BigDecimal.valueOf(200));
        payment.setOrder(order);
        return payment;
    }

    // PEGAR OS DADOS COMUM ATRIBUIR COM OS DADOS DO PIX PARA GERAR REQUEST
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

    //COPIAR OS DADOS COMUNS ENTRE OS METODOS DE PAGAMENTO
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

    // COPIAR OS DADOS COMUNS DO ORDER
    public void copyCommonOrderDetails(PaymentOrderRequest commonRequest, PaymentOrderRequest specificRequest) {
        specificRequest.setCustomer(commonRequest.getCustomer());
        specificRequest.setItems(commonRequest.getItems());
        specificRequest.setNotification_urls(commonRequest.getNotification_urls());
        specificRequest.setShipping(commonRequest.getShipping());
    }
}
