package com.dev.BookPlace.Gateway.mappers;

import com.dev.BookPlace.Gateway.models.entities.Amount;
import com.dev.BookPlace.Gateway.models.entities.Boleto;
import com.dev.BookPlace.Gateway.models.entities.Charge;
import com.dev.BookPlace.Gateway.models.entities.Holder;
import com.dev.BookPlace.Gateway.models.entities.InstructionLines;
import com.dev.BookPlace.Gateway.models.entities.PaymentMethod;
import com.dev.BookPlace.Gateway.models.entities.Shipping;
import com.dev.BookPlace.Gateway.request.BarCodeOrderRequest;
import com.dev.BookPlace.Gateway.utils.Functions;
import com.dev.BookPlace.models.entities.Order;
import com.dev.BookPlace.models.entities.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-27T11:26:24-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Red Hat, Inc.)"
)
@Component
public class ChargeMapperImpl implements ChargeMapper {

    @Override
    public Charge orderToCharge(Order order, BarCodeOrderRequest request, Functions functions) {
        if ( order == null && request == null && functions == null ) {
            return null;
        }

        Charge charge = new Charge();

        if ( order != null ) {
            if ( order.getClient() != null ) {
                if ( charge.getPayment_method() == null ) {
                    charge.setPayment_method( new PaymentMethod() );
                }
                userToPaymentMethod( order.getClient(), charge.getPayment_method() );
            }
            if ( order.getId() != null ) {
                charge.setId( String.valueOf( order.getId() ) );
            }
            if ( order.getStatus() != null ) {
                charge.setStatus( order.getStatus().name() );
            }
            if ( charge.getAmount() == null ) {
                charge.setAmount( new Amount() );
            }
            orderToAmount( order, charge.getAmount() );
        }
        if ( request != null ) {
            if ( request.getShipping() != null ) {
                if ( charge.getPayment_method() == null ) {
                    charge.setPayment_method( new PaymentMethod() );
                }
                shippingToPaymentMethod( request.getShipping(), charge.getPayment_method() );
            }
        }
        charge.setReference_id( "referencia de cobrança" );
        charge.setDescription( "descrição da cobranca" );

        return charge;
    }

    protected void userToHolder(User user, Holder mappingTarget) {
        if ( user == null ) {
            return;
        }

        mappingTarget.setName( user.getFullName() );
        mappingTarget.setEmail( user.getEmail() );
        mappingTarget.setTax_id( user.getCpf() );
    }

    protected void userToInstructionLines(User user, InstructionLines mappingTarget) {
        if ( user == null ) {
            return;
        }

        mappingTarget.setLine_1( "Pagamento processado para DESC Fatura" );
        mappingTarget.setLine_2( "Via PagSeguro" );
    }

    protected void userToBoleto(User user, Boleto mappingTarget) {
        if ( user == null ) {
            return;
        }

        if ( mappingTarget.getHolder() == null ) {
            mappingTarget.setHolder( new Holder() );
        }
        userToHolder( user, mappingTarget.getHolder() );
        if ( mappingTarget.getInstruction_lines() == null ) {
            mappingTarget.setInstruction_lines( new InstructionLines() );
        }
        userToInstructionLines( user, mappingTarget.getInstruction_lines() );

        mappingTarget.setDue_date( getDueDate() );
    }

    protected void userToPaymentMethod(User user, PaymentMethod mappingTarget) {
        if ( user == null ) {
            return;
        }

        if ( mappingTarget.getBoleto() == null ) {
            mappingTarget.setBoleto( new Boleto() );
        }
        userToBoleto( user, mappingTarget.getBoleto() );

        mappingTarget.setType( "BOLETO" );
    }

    protected void shippingToHolder(Shipping shipping, Holder mappingTarget) {
        if ( shipping == null ) {
            return;
        }

        mappingTarget.setAddress( shipping.getAddress() );
    }

    protected void shippingToInstructionLines(Shipping shipping, InstructionLines mappingTarget) {
        if ( shipping == null ) {
            return;
        }

        mappingTarget.setLine_1( "Pagamento processado para DESC Fatura" );
        mappingTarget.setLine_2( "Via PagSeguro" );
    }

    protected void shippingToBoleto(Shipping shipping, Boleto mappingTarget) {
        if ( shipping == null ) {
            return;
        }

        if ( mappingTarget.getHolder() == null ) {
            mappingTarget.setHolder( new Holder() );
        }
        shippingToHolder( shipping, mappingTarget.getHolder() );
        if ( mappingTarget.getInstruction_lines() == null ) {
            mappingTarget.setInstruction_lines( new InstructionLines() );
        }
        shippingToInstructionLines( shipping, mappingTarget.getInstruction_lines() );

        mappingTarget.setDue_date( getDueDate() );
    }

    protected void shippingToPaymentMethod(Shipping shipping, PaymentMethod mappingTarget) {
        if ( shipping == null ) {
            return;
        }

        if ( mappingTarget.getBoleto() == null ) {
            mappingTarget.setBoleto( new Boleto() );
        }
        shippingToBoleto( shipping, mappingTarget.getBoleto() );

        mappingTarget.setType( "BOLETO" );
    }

    protected void orderToAmount(Order order, Amount mappingTarget) {
        if ( order == null ) {
            return;
        }

        mappingTarget.setCurrency( "BRL" );
        mappingTarget.setValue( converterValueDoubleToBigDecimalNoDecimal(order.getTotalSum()) );
    }
}
