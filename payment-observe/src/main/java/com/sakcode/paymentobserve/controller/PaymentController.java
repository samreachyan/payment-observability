package com.sakcode.paymentobserve.controller;

import com.sakcode.paymentobserve.domain.Payment;
import com.sakcode.paymentobserve.dto.request.PaymentDTO;
import com.sakcode.paymentobserve.service.PaymentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PaymentDTO payment) {
        logger.info("Creating payment: {}", payment);
        return ResponseEntity.ok(paymentService.createPayment(payment));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getById(@PathVariable Long id) {
        logger.info("Fetching payment by id: {}", id);
        Optional<Payment> payment = paymentService.getPayment(id);
        return payment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
