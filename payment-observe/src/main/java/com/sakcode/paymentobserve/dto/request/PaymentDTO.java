package com.sakcode.paymentobserve.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaymentDTO {
    @JsonProperty(value = "payer")
    private String payer;

    @JsonProperty(value = "amount")
    private Double amount;

}
