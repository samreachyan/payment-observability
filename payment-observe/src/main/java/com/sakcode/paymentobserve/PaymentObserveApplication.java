package com.sakcode.paymentobserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentObserveApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentObserveApplication.class, args);
	}

}
