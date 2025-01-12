package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.Gateway.models.entities.Item;
import com.dev.BookPlace.models.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ItemsMapper {

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(target = "unit_amount", expression = "java(convertToCents(orderItens.getUnitAmount()))")
    })
    Item orderItemToItem(OrderItem orderItens);

    default List<Item> orderItemsToItems(Set<OrderItem> orderItems) {
        return orderItems.stream()
                .map(this::orderItemToItem)
                .collect(Collectors.toList());
    }

    default BigDecimal convertToCents(double unitAmount) {
        BigDecimal amount = BigDecimal.valueOf(unitAmount);
        BigDecimal amountInCents = amount.multiply(BigDecimal.valueOf(100)).setScale(0, RoundingMode.HALF_UP);
        return amountInCents;
    }
}
