package com.dev.BookPlace.entities.pagseguro.repositories;

import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagSeguroPixResponseRepository extends JpaRepository <PagSeguroPixResponse, String> {
}
