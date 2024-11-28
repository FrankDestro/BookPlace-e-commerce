package com.dev.BookPlace.Gateway.services;

import com.dev.BookPlace.Gateway.mappers.AmountMapper;
import com.dev.BookPlace.Gateway.mappers.LinksMapper;
import com.dev.BookPlace.Gateway.mappers.PixResponseMapper;
import com.dev.BookPlace.Gateway.mappers.QrCodeMapper;
import com.dev.BookPlace.Gateway.models.entities.Amount;
import com.dev.BookPlace.Gateway.models.entities.Link;
import com.dev.BookPlace.Gateway.models.entities.LinkQrcodes;
import com.dev.BookPlace.Gateway.models.entities.QrCode;
import com.dev.BookPlace.Gateway.repositories.PagSeguroPixResponseRepository;
import com.dev.BookPlace.Gateway.response.PagSeguroPixResponse;
import com.dev.BookPlace.enums.OrderStatus;
import com.dev.BookPlace.models.entities.Order;
import com.dev.BookPlace.models.entities.Payment;
import com.dev.BookPlace.repositories.OrderItemRepository;
import com.dev.BookPlace.repositories.OrderRepository;
import com.dev.BookPlace.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;


@RequiredArgsConstructor
@Service
public class PixService {

    private final PagSeguroPixResponseRepository pagSeguroPixResponseRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository Orderrepository;
    private final PaymentService paymentService;

    private final PixResponseMapper pixResponseMapper;
    private final QrCodeMapper qrCodeMapper;
    private final LinksMapper linksMapper;
    private final AmountMapper amountMapper;


    public void gravarOrderPixRepository(Order order, PagSeguroPixResponse pixResponse) {

        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        Orderrepository.save(order);
        orderItemRepository.saveAll(order.getItems());
        Payment payment = paymentService.createPayment(order);
        order.setPayment(payment);

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
        result.setPayment(payment);

        pagSeguroPixResponseRepository.save(result);
    }
}
