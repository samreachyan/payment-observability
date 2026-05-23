package com.sakcode.paymentobserve.service;

import com.sakcode.paymentobserve.domain.Payment;
import com.sakcode.paymentobserve.dto.request.PaymentDTO;
import com.sakcode.paymentobserve.exception.ResourceNotFoundException;
import com.sakcode.paymentobserve.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PaymentService {
    private PaymentRepository paymentRepository;

    public Payment createPayment(PaymentDTO paymentDTO) {
        log.info("Creating payment: {}", paymentDTO);
        Payment payment = new Payment();
        payment.setPayer(paymentDTO.getPayer());
        payment.setAmount(paymentDTO.getAmount());
        return paymentRepository.save(payment);
    }

    public Payment getPayment(Long id) {
        log.info("Fetching payment by id={}", id);
        return paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", id));
    }

    public List<Payment> getAllPayments() {
        log.info("Fetching all payments");
        return paymentRepository.findAll();
    }

    public Payment updatePayment(Long id, PaymentDTO paymentDTO) {
        log.info("Updating payment id={} with {}", id, paymentDTO);
        Payment existing = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", id));

        existing.setPayer(paymentDTO.getPayer());
        existing.setAmount(paymentDTO.getAmount());
        return paymentRepository.save(existing);
    }

    public void deletePayment(Long id) {
        log.info("Deleting payment by id={}", id);
        Payment existing = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", id));
        paymentRepository.delete(existing);
    }
}
