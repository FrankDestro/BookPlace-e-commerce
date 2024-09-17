package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.pagseguro.models.entities.Item;
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
    Item orderItemToItem(com.dev.BookPlace.entities.OrderItem orderItens);

    default List<Item> orderItemsToItems(Set<com.dev.BookPlace.entities.OrderItem> orderItems) {
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
