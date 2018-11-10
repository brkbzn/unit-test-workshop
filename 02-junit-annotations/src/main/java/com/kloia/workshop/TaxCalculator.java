package com.kloia.workshop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {

    public static final BigDecimal DEFAULT_RATE = BigDecimal.valueOf(18);

    private DatabaseConnection databaseConnection;

    public TaxCalculator(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public BigDecimal calculateTax(BigDecimal amount) throws Exception {
        if (databaseConnection.isClosed()) {
            throw new Exception("Database connection is not opened yet");
        }

        if (amount == null) {
            return null;
        }

        return amount.multiply(TaxCalculator.DEFAULT_RATE).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

}
