package com.dev.BookPlace.entities.pagseguro.mappers;

import com.dev.BookPlace.entities.pagseguro.response.PagSeguroPixResponse;
import com.dev.BookPlace.entities.pagseguro.response.PaymentProviderPixDetails;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-16T14:31:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Red Hat, Inc.)"
)
@Component
public class PaymentProviderPixDetailsMapperImpl implements PaymentProviderPixDetailsMapper {

    @Override
    public PaymentProviderPixDetails mapToPaymentProviderDetails(PagSeguroPixResponse pixResponse) {
        if ( pixResponse == null ) {
            return null;
        }

        PaymentProviderPixDetails paymentProviderPixDetails = new PaymentProviderPixDetails();

        paymentProviderPixDetails.setId( pixResponse.getId() );
        paymentProviderPixDetails.setCreated_at( pixResponse.getCreated_at() );
        paymentProviderPixDetails.setCustomer( pixResponse.getCustomer() );
        List<PagSeguroPixResponse.Item> list = pixResponse.getItems();
        if ( list != null ) {
            paymentProviderPixDetails.setItems( new ArrayList<PagSeguroPixResponse.Item>( list ) );
        }
        paymentProviderPixDetails.setShipping( pixResponse.getShipping() );
        List<PagSeguroPixResponse.QRCode> list1 = pixResponse.getQr_codes();
        if ( list1 != null ) {
            paymentProviderPixDetails.setQr_codes( new ArrayList<PagSeguroPixResponse.QRCode>( list1 ) );
        }
        List<String> list2 = pixResponse.getNotification_urls();
        if ( list2 != null ) {
            paymentProviderPixDetails.setNotification_urls( new ArrayList<String>( list2 ) );
        }
        List<PagSeguroPixResponse.Link> list3 = pixResponse.getLinks();
        if ( list3 != null ) {
            paymentProviderPixDetails.setLinks( new ArrayList<PagSeguroPixResponse.Link>( list3 ) );
        }

        return paymentProviderPixDetails;
    }
}
