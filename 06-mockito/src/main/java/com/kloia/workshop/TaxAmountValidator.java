package com.kloia.workshop;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TaxAmountValidator {

    public void validate(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
    }

}
