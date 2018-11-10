package com.kloia.workshop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class TaxCalculator {

    private static final String DEFAULT_TAX_TYPE = "KDV";
    private static final BigDecimal DEFAULT_TAX_RATE = BigDecimal.valueOf(18);
    private static final BigDecimal DEFAULT_DISCOUNT_RATE = BigDecimal.valueOf(10);
    private static final List<String> AVAILABLE_TAXES = Arrays.asList("KDV", "OTV", "MTV");

    private DatabaseConnection databaseConnection;
    private BigDecimal taxRate;
    private BigDecimal discountRate;

    public TaxCalculator(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
        this.taxRate = DEFAULT_TAX_RATE;
        this.discountRate = DEFAULT_DISCOUNT_RATE;
    }

    public TaxCalculator(DatabaseConnection databaseConnection, BigDecimal taxRate, BigDecimal discountRate) {
        this.databaseConnection = databaseConnection;
        this.taxRate = taxRate;
        this.discountRate = discountRate;
    }

    public List<String> getAvailableTaxes() {
        return AVAILABLE_TAXES;
    }

    public String getDefaultTaxType() {
        return DEFAULT_TAX_TYPE;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public BigDecimal calculate(BigDecimal amount, boolean hasDiscount) throws Exception {
        if (databaseConnection.isClosed()) {
            throw new Exception("Database connection is not opened yet");
        }

        if (amount == null) {
            return null;
        }

        if (!hasDiscount) {
            return amount.multiply(taxRate).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        }

        BigDecimal effectiveRate = taxRate.subtract(discountRate);

        return amount.multiply(effectiveRate).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

}
