package com.dev.BookPlace.controller;

import com.dev.BookPlace.dto.AddressDTO;
import com.dev.BookPlace.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_OPERATOR')")
    @GetMapping
    public ResponseEntity<List<AddressDTO>> findAllAddressList() {
        List<AddressDTO> list = addressService.findAllAddressList();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<AddressDTO> insertAddress(@Valid @RequestBody AddressDTO dto) {
        dto = addressService.insertAddress(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable Long id, @Valid @RequestBody AddressDTO dto) {
        dto = addressService.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
