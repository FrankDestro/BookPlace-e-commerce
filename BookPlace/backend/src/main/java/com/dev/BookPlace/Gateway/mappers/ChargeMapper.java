package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.models.entities.Order;
import com.dev.BookPlace.Gateway.models.entities.Charge;
import com.dev.BookPlace.Gateway.utils.Functions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.dev.BookPlace.Gateway.request.BarCodeOrderRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


@Mapper(componentModel="spring")
public interface ChargeMapper {

    ChargeMapper INSTANCE = Mappers.getMapper(ChargeMapper.class);

    @Mapping(target = "reference_id", constant = "referencia de cobrança")
    @Mapping(target = "description", constant = "descrição da cobranca")
    @Mapping(target = "amount.currency", constant = "BRL")
    @Mapping(target = "amount.value", expression = "java(converterValueDoubleToBigDecimalNoDecimal(order.getTotalSum()))")
    @Mapping(target = "payment_method.type", constant = "BOLETO")
    @Mapping(target = "payment_method.boleto.due_date", expression = "java(getDueDate())")
    @Mapping(target = "payment_method.boleto.instruction_lines.line_1", constant = "Pagamento processado para DESC Fatura")
    @Mapping(target = "payment_method.boleto.instruction_lines.line_2", constant = "Via PagSeguro")
    @Mapping(target = "payment_method.boleto.holder.name", source = "order.client.fullName")
    @Mapping(target = "payment_method.boleto.holder.email", source = "order.client.email")
    @Mapping(target = "payment_method.boleto.holder.tax_id", source = "order.client.cpf")
    @Mapping(target = "payment_method.boleto.holder.address", source = "request.shipping.address")
    Charge orderToCharge(Order order, BarCodeOrderRequest request, Functions functions);

    default BigDecimal converterValueDoubleToBigDecimalNoDecimal(Double value) {
        BigDecimal unitAmount = new BigDecimal(value);
        BigDecimal unitAmountInCents = unitAmount.multiply(BigDecimal.valueOf(100)).setScale(0, RoundingMode.HALF_UP);
        long unitAmountLong = unitAmountInCents.longValue();
        return BigDecimal.valueOf(unitAmountLong);
    }

    default String getDueDate() {
        Instant now = Instant.now();
        Instant dueDateInstant = now.plus(Duration.ofDays(3));
        LocalDateTime dateTime = LocalDateTime.ofInstant(dueDateInstant, ZoneId.systemDefault());
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(dateTime);
    }
}


