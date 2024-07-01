package com.dev.BookPlace.dto;

import com.dev.BookPlace.entities.bookplace.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String fullName;
    private String cpf;
    private LocalDate birthDate;
    private String email;
    private String password;

    private List<RoleDTO> roles = new ArrayList<>();

    private List<AddressDTO> address = new ArrayList<>();

    private List<PhoneDTO> phones = new ArrayList<>();

    public UserDTO(User user) {
        id = user.getId();
        fullName = user.getFullName();
        cpf = user.getCpf();
        birthDate = user.getBirthDate();
        email = user.getEmail();
        user.getRoles().forEach(roles -> this.roles.add(new RoleDTO(roles)));
//        user.getAddress().forEach(role -> this.address.add(new AddressDTO(role)));
        user.getPhones().forEach(phones -> this.phones.add(new PhoneDTO(phones)));
    }
}
