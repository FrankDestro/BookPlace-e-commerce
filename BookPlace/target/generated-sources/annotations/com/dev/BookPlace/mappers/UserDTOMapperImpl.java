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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-01T16:23:10-0300",
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

    @Override
    public User toUserEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setFullName( userDTO.getFullName() );
        user.setCpf( userDTO.getCpf() );
        user.setBirthDate( userDTO.getBirthDate() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );
        user.setAddress( addressDTOListToAddressList( userDTO.getAddress() ) );
        user.setPhones( phoneDTOListToPhoneList( userDTO.getPhones() ) );
        if ( user.getRoles() != null ) {
            Set<Role> set = roleDTOListToRoleSet( userDTO.getRoles() );
            if ( set != null ) {
                user.getRoles().addAll( set );
            }
        }

        return user;
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

    protected Address addressDTOToAddress(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDTO.getId() );
        address.setStreet( addressDTO.getStreet() );
        address.setNumber( addressDTO.getNumber() );
        address.setComplement( addressDTO.getComplement() );
        address.setLocality( addressDTO.getLocality() );
        address.setCity( addressDTO.getCity() );
        address.setRegionCode( addressDTO.getRegionCode() );
        address.setCountry( addressDTO.getCountry() );
        address.setPostalCode( addressDTO.getPostalCode() );
        address.setMain( addressDTO.getMain() );

        return address;
    }

    protected List<Address> addressDTOListToAddressList(List<AddressDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Address> list1 = new ArrayList<Address>( list.size() );
        for ( AddressDTO addressDTO : list ) {
            list1.add( addressDTOToAddress( addressDTO ) );
        }

        return list1;
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone phone = new Phone();

        phone.setId( phoneDTO.getId() );
        phone.setCountry( phoneDTO.getCountry() );
        phone.setArea( phoneDTO.getArea() );
        phone.setNumber( phoneDTO.getNumber() );
        phone.setType( phoneDTO.getType() );

        return phone;
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected Role roleDTOToRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDTO.getId() );
        role.setAuthority( roleDTO.getAuthority() );

        return role;
    }

    protected Set<Role> roleDTOListToRoleSet(List<RoleDTO> list) {
        if ( list == null ) {
            return null;
        }

        Set<Role> set = new LinkedHashSet<Role>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( RoleDTO roleDTO : list ) {
            set.add( roleDTOToRole( roleDTO ) );
        }

        return set;
    }
}
