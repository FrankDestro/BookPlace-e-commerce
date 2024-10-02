package com.dev.BookPlace.Gateway.repositories;

import com.dev.BookPlace.Gateway.response.PagSeguroPixResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagSeguroPixResponseRepository extends JpaRepository <PagSeguroPixResponse, String> {
}
