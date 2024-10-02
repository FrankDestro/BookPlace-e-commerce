package com.dev.BookPlace.mappers;

import com.dev.BookPlace.models.dto.UserDTO;
import com.dev.BookPlace.models.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserDTOMapper {

    UserDTO toUserDTO(User user);
    User toUserEntity(UserDTO userDTO);

}
