package com.sakcode.paymentobserve.controller;

import com.sakcode.paymentobserve.domain.Payment;
import com.sakcode.paymentobserve.dto.request.PaymentDTO;
import com.sakcode.paymentobserve.dto.response.ApiResponse;
import com.sakcode.paymentobserve.service.PaymentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Payment>> create(@Valid @RequestBody PaymentDTO payment) {
        logger.info("Creating payment: {}", payment);
        Payment created = paymentService.createPayment(payment);
        ApiResponse<Payment> response = ApiResponse.success(
                HttpStatus.CREATED.value(),
                "Payment created successfully",
                created
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> getById(@PathVariable Long id) {
        logger.info("Fetching payment by id: {}", id);
        Payment payment = paymentService.getPayment(id);
        ApiResponse<Payment> response = ApiResponse.success(
                HttpStatus.OK.value(),
                "Payment retrieved successfully",
                payment
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Payment>>> getAll() {
        logger.info("Fetching all payments");
        List<Payment> payments = paymentService.getAllPayments();
        ApiResponse<List<Payment>> response = ApiResponse.success(
                HttpStatus.OK.value(),
                "Payments retrieved successfully",
                payments
        );
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Payment>> update(@PathVariable Long id,
                                                       @Valid @RequestBody PaymentDTO payment) {
        logger.info("Updating payment id={} with {}", id, payment);
        Payment updated = paymentService.updatePayment(id, payment);
        ApiResponse<Payment> response = ApiResponse.success(
                HttpStatus.OK.value(),
                "Payment updated successfully",
                updated
        );
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        logger.info("Deleting payment by id: {}", id);
        paymentService.deletePayment(id);
        ApiResponse<Void> response = ApiResponse.success(
                HttpStatus.OK.value(),
                "Payment deleted successfully",
                null
        );
        return ResponseEntity.ok(response);
    }
}
