package com.dev.BookPlace.mappers;

import com.dev.BookPlace.models.dto.RoleDTO;
import com.dev.BookPlace.models.entities.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-27T11:26:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Red Hat, Inc.)"
)
@Component
public class RoleDTOMapperImpl implements RoleDTOMapper {

    @Override
    public List<RoleDTO> toRoleDTOList(List<Role> roleList) {
        if ( roleList == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( roleList.size() );
        for ( Role role : roleList ) {
            list.add( roleToRoleDTO( role ) );
        }

        return list;
    }

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setAuthority( role.getAuthority() );

        return roleDTO;
    }
}
