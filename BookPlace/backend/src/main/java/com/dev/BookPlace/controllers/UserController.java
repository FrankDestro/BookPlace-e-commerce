package com.dev.BookPlace.controllers;

import com.dev.BookPlace.models.dto.UserDTO;
import com.dev.BookPlace.models.dto.UserInsertDTO;
import com.dev.BookPlace.models.dto.UserUpdateDTO;
import com.dev.BookPlace.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findUserById(@PathVariable Long id) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication.getPrincipal() instanceof UserDetails userDetails) {
                log.debug("Nome de usuário: %s".formatted(userDetails.getUsername()));
                log.debug("Roles: %s".formatted(userDetails.getAuthorities()));
            }
            UserDTO dto = userService.findUserById(id);
            return ResponseEntity.ok().body(dto);
        } catch (AccessDeniedException e) {
            log.info("Acesso negado: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Acesso negado: " + e.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
        Page<UserDTO> listUser = userService.findAllUserPaged(pageable);
        return ResponseEntity.ok().body(listUser);
    }

    @GetMapping(value = "/logged")
    public ResponseEntity<UserDTO> Profile() {
        UserDTO dto = userService.findUserLogged();
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserDTO> register(@RequestBody @Valid UserInsertDTO dto) {
        UserDTO newDto = userService.Register(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDto.getId()).toUri();
        return ResponseEntity.created(uri).body(newDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserUpdateDTO dto) {
        UserDTO newDto = userService.update(id, dto);
        return ResponseEntity.ok().body(newDto);
    }
}
