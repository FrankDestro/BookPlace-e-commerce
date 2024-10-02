package com.dev.BookPlace.models.dto;

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

}
