package com.dev.BookPlace.repositories;

import com.dev.BookPlace.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {

    Role findByAuthority(String authority);
}
