package com.dev.BookPlace.repositories;

import com.dev.BookPlace.entities.Pix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PixRepository extends JpaRepository <Pix, Long> {
}
