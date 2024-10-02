package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.Gateway.models.entities.QrCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel="spring")
public interface QrCodeMapper {

    @Mappings({
            @Mapping(target = "amount", ignore = true),
            @Mapping(target = "links", ignore = true),
            @Mapping(target = "arrangements", ignore = true)
    })
    QrCode toQrcodeCompleted(QrCode qrCode);

    default List<QrCode> toQrcodeCompleted(List<QrCode> qrCodes) {
        return qrCodes.stream()
                .map(this::toQrcodeCompleted)
                .collect(Collectors.toList());
    }

    List<String> toListArrangements(List<String> arrangements);

}
