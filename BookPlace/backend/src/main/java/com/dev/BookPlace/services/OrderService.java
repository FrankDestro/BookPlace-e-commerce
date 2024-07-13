package com.dev.BookPlace.services;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.dto.OrderDTO;
import com.dev.BookPlace.dto.OrderItemDTO;
import com.dev.BookPlace.entities.Address;
import com.dev.BookPlace.entities.*;
import com.dev.BookPlace.entities.pagseguro.entities.Phone;
import com.dev.BookPlace.entities.pagseguro.entities.*;
import com.dev.BookPlace.entities.pagseguro.integration.PagSeguroPixClient;
import com.dev.BookPlace.entities.pagseguro.request.PixOrderRequest;
import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse;
import com.dev.BookPlace.enums.OrderStatus;
import com.dev.BookPlace.enums.PaymentMethod;
import com.dev.BookPlace.enums.PaymentStatus;
import com.dev.BookPlace.repositories.*;
import com.dev.BookPlace.services.exceptions.ResourceNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PagSeguroPixClient pagSeguroPixClient;

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }


    @Transactional
    public OrderDTO recordOder(OrderDTO dto) throws JsonProcessingException {

        Order order = new Order();
        PaymentMethod paymentMethod = PaymentMethod.PIX;
        User user = userService.authenticated();
        order.setClient(user);

        AddressDTO address = dto.getAddress();
        Address addressShipping = addressRepository.getReferenceById(address.getId());
        order.setAddress(addressShipping);

        for (OrderItemDTO itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            double amount = product.getPrice() * itemDto.getQuantity();
            OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice(), amount, product.getName());
            order.getItems().add(item);
        }

        PixOrderRequest pixOrderRequest = createPixOrderRequest(order);
        String authorizationToken = System.getenv("PAGSEGURO_AUTH_TOKEN");
        String bearerToken = "Bearer " + authorizationToken;
        PagSeguroPixResponse pixResponse = pagSeguroPixClient.createPixOrder(bearerToken, pixOrderRequest);

        if (pixResponse != null && !pixResponse.getId().isEmpty()) {

            order.setMoment(Instant.now());
            order.setStatus(OrderStatus.WAITING_PAYMENT);
            repository.save(order);
            orderItemRepository.saveAll(order.getItems());
            Payment payment = createPayment(order);
            paymentRepository.save(payment);

        } else {
            throw new RuntimeException("Erro ao processar pagamento Pix.");
        }

        return new OrderDTO(order);
    }


    private Payment createPayment(Order order) {
        Payment payment = new Payment();
        payment.setPaymentStatus(PaymentStatus.WAITING_PAYMENT); // Exemplo de status genérico
        payment.setPaymentDate(LocalDateTime.now());
        payment.setAmount(BigDecimal.valueOf(200));
        payment.setOrder(order);
        return payment;
    }

    private PixOrderRequest createPixOrderRequest(Order order) {
        PixOrderRequest request = new PixOrderRequest();

        // Customer
        Customer customer = new Customer();
        customer.setName(order.getClient().getFullName());
        customer.setEmail(order.getClient().getEmail());
        customer.setTax_id(order.getClient().getCpf());
        request.setCustomer(customer);

        // Phones
        List<Phone> phones = new ArrayList<>();

        for (com.dev.BookPlace.entities.Phone clientPhone : order.getClient().getPhones()) {
            Phone phone = new Phone();
            phone.setCountry(clientPhone.getCountry().toString());
            phone.setArea(clientPhone.getArea().toString());
            phone.setNumber(clientPhone.getNumber().toString());
            phone.setType(clientPhone.getType());
            phones.add(phone);
        }
        customer.setPhones(phones);
        request.setCustomer(customer);

        // Itens
        List<Item> items = new ArrayList<>();
        for (com.dev.BookPlace.entities.OrderItem orderItens : order.getItems()) {
            Item item = new Item();
            item.setName(orderItens.getName());
            item.setQuantity(orderItens.getQuantity());

            System.out.println("valor inalterado " + item.getUnit_amount());

            BigDecimal unitAmount = new BigDecimal(orderItens.getUnitAmount());
            BigDecimal unitAmountInCents = unitAmount.multiply(BigDecimal.valueOf(100)).setScale(0, RoundingMode.HALF_UP);
            long unitAmountLong = unitAmountInCents.longValue();

            item.setUnit_amount(BigDecimal.valueOf(unitAmountLong));

            System.out.println("valor atual " + item.getUnit_amount());

            items.add(item);
        }
        request.setItems(items);

        // QRCode
        List<QrCode> qr_codes = new ArrayList<>();
        QrCode qrCode = new QrCode();
        Amount amount = new Amount();
        amount.setValue(BigDecimal.valueOf(200));
        qrCode.setAmount(amount);
        Instant expirationDate = Instant.now().plus(Duration.ofMinutes(15));
        qrCode.setExpiration_date(expirationDate.toString());
        qr_codes.add(qrCode);
        request.setQr_codes(qr_codes);

        // Notification
        List<String> listNotificationUrl = new ArrayList<>();
        listNotificationUrl.add("https://meusite.com/notificacoes");
        request.setNotification_urls(listNotificationUrl);

        //Shipping
        Shipping shipping = new Shipping();
        shipping.getAddress().setStreet(order.getAddress().getStreet());
        shipping.getAddress().setNumber(order.getAddress().getComplement());
        shipping.getAddress().setLocality(order.getAddress().getLocality());
        shipping.getAddress().setCity(order.getAddress().getLocality());
        shipping.getAddress().setRegion_code(order.getAddress().getRegionCode());
        shipping.getAddress().setCountry(order.getAddress().getCountry());
        shipping.getAddress().setPostal_code(order.getAddress().getPostalCode());
        request.setShipping(shipping);

        return request;
    }
}
