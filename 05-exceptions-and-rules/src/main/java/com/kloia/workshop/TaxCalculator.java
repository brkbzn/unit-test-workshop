package com.kloia.workshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {

    private static final BigDecimal DEFAULT_TAX_RATE = BigDecimal.valueOf(18);


    public BigDecimal calculate(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        BigDecimal tax = amount.multiply(DEFAULT_TAX_RATE).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        return tax;
    }

}
