package com.innowise.ryabov.cos4.service;

import com.innowise.ryabov.cos4.dto.PaymentDTO;
import com.innowise.ryabov.cos4.request.PaymentRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public interface PaymentService {
    List<PaymentDTO> getAllPayments();
    void savePayment(@Valid PaymentRequest payment);
    PaymentDTO updatePayment(Long id, @Valid PaymentRequest paymentRequest);
    void deletePayment(Long id);
    PaymentDTO getPayment(Long id);
}
