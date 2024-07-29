package com.innowise.ryabov.cos4.controller;

import com.innowise.ryabov.cos4.dto.PaymentDTO;
import com.innowise.ryabov.cos4.request.PaymentRequest;
import com.innowise.ryabov.cos4.service.PaymentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    PaymentService paymentService;
    @GetMapping("/get")
    public ResponseEntity<List<PaymentDTO>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<PaymentDTO> getPayment(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPayment(id));
    }
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> savePayment(@RequestBody PaymentRequest paymentRequest) {
        paymentService.savePayment(paymentRequest);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PaymentDTO> updatePayment(@PathVariable Long id, @RequestBody PaymentRequest paymentDetails) {
        PaymentDTO payment = paymentService.updatePayment(id, paymentDetails);
        return ResponseEntity.ok(payment);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }
}