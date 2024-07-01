package com.dev.BookPlace.mappers;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.dto.PhoneDTO;
import com.dev.BookPlace.dto.RoleDTO;
import com.dev.BookPlace.dto.UserDTO;
import com.dev.BookPlace.entities.bookplace.entities.Address;
import com.dev.BookPlace.entities.bookplace.entities.Phone;
import com.dev.BookPlace.entities.bookplace.entities.Role;
import com.dev.BookPlace.entities.bookplace.entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-01T14:47:34-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Red Hat, Inc.)"
)
@Component
public class UserDTOMapperImpl implements UserDTOMapper {

    @Override
    public UserDTO toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setFullName( user.getFullName() );
        userDTO.setCpf( user.getCpf() );
        userDTO.setBirthDate( user.getBirthDate() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setRoles( roleSetToRoleDTOList( user.getRoles() ) );
        userDTO.setAddress( addressListToAddressDTOList( user.getAddress() ) );
        userDTO.setPhones( phoneListToPhoneDTOList( user.getPhones() ) );

        return userDTO;
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

    protected List<RoleDTO> roleSetToRoleDTOList(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( set.size() );
        for ( Role role : set ) {
            list.add( roleToRoleDTO( role ) );
        }

        return list;
    }

    protected AddressDTO addressToAddressDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( address.getId() );
        addressDTO.setStreet( address.getStreet() );
        addressDTO.setNumber( address.getNumber() );
        addressDTO.setComplement( address.getComplement() );
        addressDTO.setLocality( address.getLocality() );
        addressDTO.setCity( address.getCity() );
        addressDTO.setRegionCode( address.getRegionCode() );
        addressDTO.setCountry( address.getCountry() );
        addressDTO.setPostalCode( address.getPostalCode() );
        addressDTO.setMain( address.getMain() );

        return addressDTO;
    }

    protected List<AddressDTO> addressListToAddressDTOList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressDTO> list1 = new ArrayList<AddressDTO>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToAddressDTO( address ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO phoneDTO = new PhoneDTO();

        phoneDTO.setId( phone.getId() );
        phoneDTO.setCountry( phone.getCountry() );
        phoneDTO.setArea( phone.getArea() );
        phoneDTO.setNumber( phone.getNumber() );
        phoneDTO.setType( phone.getType() );

        return phoneDTO;
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}
