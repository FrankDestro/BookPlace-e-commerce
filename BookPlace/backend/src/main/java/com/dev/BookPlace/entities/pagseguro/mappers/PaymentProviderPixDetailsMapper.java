package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse;
import com.dev.BookPlace.entities.pagseguro.response.PaymentProviderPixDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface PaymentProviderPixDetailsMapper {

    PaymentProviderPixDetails mapToPaymentProviderDetails(PagSeguroPixResponse pixResponse);
}
