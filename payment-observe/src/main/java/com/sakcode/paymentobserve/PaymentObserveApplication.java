package com.sakcode.paymentobserve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentObserveApplication {
	@Bean
	MeterRegistryCustomizer metricsCommonTags() {
		return registry -> registry.config().commonTags("application", "Payment-Service");
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentObserveApplication.class, args);
	}

}
