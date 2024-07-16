package com.dev.BookPlace.entities.pagseguro.repository;

import com.dev.BookPlace.entities.pagseguro.response.PaymentProviderPixDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentProviderPixDetailsRepository extends JpaRepository<PaymentProviderPixDetails, String> {
}
