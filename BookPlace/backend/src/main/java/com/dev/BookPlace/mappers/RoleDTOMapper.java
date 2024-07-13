package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.RoleDTO;
import com.dev.BookPlace.entities.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface RoleDTOMapper {
    List<RoleDTO> toRoleDTOList(List<Role> roleList);
}
