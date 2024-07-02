package com.dev.BookPlace.controllers;

import com.dev.BookPlace.dto.PhoneDTO;
import com.dev.BookPlace.services.PhoneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    @PostMapping
    public ResponseEntity<PhoneDTO> savePhoneNumber(@Valid @RequestBody PhoneDTO phoneDTO) {
        phoneDTO = phoneService.savePhoneNumber(phoneDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(phoneDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(phoneDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletePhoneNumber(@PathVariable Long id) {
        phoneService.deletePhoneNumber(id);
        return ResponseEntity.noContent().build();
    }
}
