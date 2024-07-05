package com.dev.BookPlace.factory;

import com.dev.BookPlace.dto.UserDTO;
import com.dev.BookPlace.entities.bookplace.entities.Role;
import com.dev.BookPlace.entities.bookplace.entities.User;
import com.dev.BookPlace.mappers.UserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class UserFactory {

    @Autowired
    private UserDTOMapper userDTOMapper;

    public static UserDTO createUserClientDTO() {
        UserDTO userDTO = new UserDTO(
                1L,
                "Marcos Santos",
                "34578987632",
                LocalDate.parse("1985-10-30"),
                "marcos.santos@gmail.com",
                "123456",
                null,
                null, null);
        return userDTO;
    }

    public static User createUserClient() {
        User user = new User(1L, "Marcos Santos", "34578987632", LocalDate.parse("1985-10-30"),
                "marcos.santos@gmail.com",
                "123456",
                null,
                null);
        user.addRole(new Role(1L, "ROLE_OPERATOR"));
        return user;
    }

    public static UserDTO createUserAdminDTO() {
        UserDTO userDTO = new UserDTO(
                1L,
                "Alice Oliveira",
                "01177856989",
                LocalDate.parse("1990-04-10"),
                "alice.oliveira@gmail.com",
                "123456",
                null,
                null,
                null);
        return userDTO;
    }

    public static User createUserAdmin() {
        User user = new User(1L, "Alice Oliveira", "01177856989", LocalDate.parse("1990-04-10"),
                "alice.oliveira@gmail.com",
                "123456",
                null,
                null);
        user.addRole(new Role(1L, "ROLE_Admin"));
        return user;
    }
}
