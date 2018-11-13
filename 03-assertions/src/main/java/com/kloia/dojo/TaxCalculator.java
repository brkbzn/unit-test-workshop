package com.kloia.dojo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class TaxCalculator {

    private static final String DEFAULT_TAX_TYPE = "KDV";
    private static final BigDecimal DEFAULT_TAX_RATE = BigDecimal.valueOf(18);
    private static final BigDecimal DEFAULT_DISCOUNT_RATE = BigDecimal.valueOf(10);
    private static final List<String> AVAILABLE_TAXES = Arrays.asList("KDV", "OTV", "MTV");


    public List<String> getAvailableTaxes() {
        return AVAILABLE_TAXES;
    }

    public String getDefaultTaxType() {
        return DEFAULT_TAX_TYPE;
    }

    public BigDecimal getTaxRate() {
        return DEFAULT_TAX_RATE;
    }


    public BigDecimal calculate(BigDecimal amount, boolean hasDiscount) {
        if (amount == null) {
            return null;
        }

        if (!hasDiscount) {
            return amount.multiply(DEFAULT_TAX_RATE).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        }

        BigDecimal effectiveRate = DEFAULT_TAX_RATE.subtract(DEFAULT_DISCOUNT_RATE);

        BigDecimal tax = amount.multiply(effectiveRate).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        return tax;
    }

}
