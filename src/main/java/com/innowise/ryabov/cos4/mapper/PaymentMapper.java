package com.innowise.ryabov.cos4.mapper;

import com.innowise.ryabov.cos4.dto.PaymentDTO;
import com.innowise.ryabov.cos4.entity.Payment;
import com.innowise.ryabov.cos4.request.PaymentRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO paymentToPaymentDTO(Payment payment);
    Payment paymentRequestToPayment(PaymentRequest paymentRequest);
}
