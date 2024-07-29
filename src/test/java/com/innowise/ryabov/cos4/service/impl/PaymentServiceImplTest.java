package com.innowise.ryabov.cos4.service.impl;

import com.innowise.ryabov.cos4.dto.PaymentDTO;
import com.innowise.ryabov.cos4.entity.Payment;
import com.innowise.ryabov.cos4.mapper.PaymentMapper;
import com.innowise.ryabov.cos4.repository.PaymentRepository;
import com.innowise.ryabov.cos4.request.PaymentRequest;
import com.innowise.ryabov.cos4.util.PaymentNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {
    @Mock
    PaymentRepository paymentRepository;
    @InjectMocks
    PaymentServiceImpl paymentService;
    @Mock
    PaymentMapper mapper;
    @Test
    void getAllPayments() {
        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment());

        when(paymentRepository.findAll()).thenReturn(payments);
        when(mapper.paymentToPaymentDTO(Mockito.any(Payment.class))).thenReturn(new PaymentDTO());

        assertNotNull(paymentService.getAllPayments());
    }

    @Test
    void savePayment() {
        PaymentRequest request = new PaymentRequest(null,
                null,
                null,
                null);

        when(mapper.paymentRequestToPayment(request)).thenReturn(new Payment());

        paymentService.savePayment(request);

        verify(paymentRepository, times(1)).save(new Payment());
    }

    @Test
    void updatePayment() {
        Long id = 1L;
        PaymentRequest request = new PaymentRequest("brand",
                null,
                null,
                null);
        Payment payment = new Payment();

        when(paymentRepository.findById(Mockito.any())).thenReturn(Optional.of(payment));

        paymentService.updatePayment(id, request);

        assertEquals(request.paymentAmount(), payment.getPaymentAmount());
        assertEquals(request.url(), payment.getUrl());
        assertEquals(request.paymentDate(), payment.getPaymentDate());
        assertEquals(request.status(), payment.getStatus());
    }

    @Test
    void deletePayment() {
        Long id = 1L;
        Payment car = new Payment();

        when(paymentRepository.findById(Mockito.any())).thenReturn(Optional.of(car));

        paymentService.deletePayment(id);

        verify(paymentRepository, times(1)).deleteById(car.getId());
    }

    @Test
    void getPayment() {
        Long id = 1L;
        Payment car = new Payment();

        when(mapper.paymentToPaymentDTO(any(Payment.class))).thenReturn(new PaymentDTO());
        when(paymentRepository.findById(Mockito.any())).thenReturn(Optional.of(car));

        paymentService.getPayment(id);

        verify(paymentRepository, times(1)).findById(id);
    }

    @Test
    void deletePayment_ThrowNotFoundPaymentException() {
        Long id = 1L;

        when(paymentRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(PaymentNotFoundException.class, () -> paymentService.deletePayment(id));
    }
    @Test
    void getPayment_ThrowNotFoundPaymentException() {
        Long id = 1L;

        when(paymentRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        assertThrows(PaymentNotFoundException.class, () -> paymentService.getPayment(id));
    }
    @Test
    void updatePayment_ThrowNotFoundPaymentException() {
        Long id = 1L;
        PaymentRequest request = new PaymentRequest(null,
                null,
                null,
                null
        );

        when(paymentRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(PaymentNotFoundException.class, () -> paymentService.updatePayment(id,request));
    }
}