package com.innowise.ryabov.cos4.service.impl;
import com.innowise.ryabov.cos4.dto.PaymentDTO;
import com.innowise.ryabov.cos4.entity.Payment;
import com.innowise.ryabov.cos4.mapper.PaymentMapper;
import com.innowise.ryabov.cos4.messages.PropertyUtil;
import com.innowise.ryabov.cos4.repository.PaymentRepository;
import com.innowise.ryabov.cos4.request.PaymentRequest;
import com.innowise.ryabov.cos4.service.PaymentService;
import com.innowise.ryabov.cos4.util.PaymentNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMapper mapper;

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(mapper::paymentToPaymentDTO)
                .toList();
    }

    @Override
    public void savePayment(PaymentRequest paymentRequest) {
        paymentRepository.save(mapper.paymentRequestToPayment(paymentRequest));
    }

    @Override
    public PaymentDTO updatePayment(Long id, PaymentRequest paymentRequest) {
        Payment payment = findSafe(id);
        payment.setPaymentDate(paymentRequest.paymentDate());
        payment.setUrl(paymentRequest.url());
        payment.setStatus(paymentRequest.status());
        payment.setPaymentAmount(paymentRequest.paymentAmount());
        return mapper.paymentToPaymentDTO(payment);
    }
    @Override
    public void deletePayment(Long id) {
        val payment = findSafe(id);
        paymentRepository.deleteById(payment.getId());
    }
    @Override
    public PaymentDTO getPayment(Long id) {
        return mapper.paymentToPaymentDTO(findSafe(id));
    }
    private Payment findSafe(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(
                        () -> new PaymentNotFoundException(PropertyUtil.PAYMENT_NOT_FOUND_MESSAGE)
                );
    }
}