package com.sakcode.paymentobserve.service;

import com.sakcode.paymentobserve.domain.Payment;
import com.sakcode.paymentobserve.dto.request.PaymentDTO;
import com.sakcode.paymentobserve.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentService {
    private PaymentRepository paymentRepository;

    public Payment createPayment(PaymentDTO paymentDTO) {
        Payment payment = new Payment();
        payment.setPayer(paymentDTO.getPayer());
        payment.setAmount(paymentDTO.getAmount());
        return paymentRepository.save(payment);
    }

    public Optional<Payment> getPayment(Long id) {
        return paymentRepository.findById(id);
    }

}
