package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.PhoneDTO;
import com.dev.BookPlace.entities.bookplace.entities.Phone;
import com.dev.BookPlace.entities.bookplace.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public interface PhoneDTOMapper {

    @Mapping(source = "client", target = "userId", qualifiedByName = "userToUserId")
    PhoneDTO toPhoneDTO(Phone phone);

    @Named("userToUserId")
    default Long map(User user) {
        return user == null ? null : user.getId();
    }

    Phone toPhoneEntity(PhoneDTO phoneDTO);

    @Mapping(target = "id", ignore = true)
    void updatePhoneFromDTO(PhoneDTO phoneDTO, @MappingTarget Phone phone);

    List<Phone> toPhoneList(List<PhoneDTO> phoneDTOList);
}