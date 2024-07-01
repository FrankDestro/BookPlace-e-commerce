package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.UserDTO;
import com.dev.BookPlace.entities.bookplace.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface UserDTOMapper {

    UserDTO toUserDTO(User user);
}
