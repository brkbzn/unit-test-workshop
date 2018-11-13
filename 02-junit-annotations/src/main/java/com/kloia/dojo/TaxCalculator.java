package com.kloia.dojo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculator {

    public static final BigDecimal DEFAULT_RATE = BigDecimal.valueOf(18);

    private DatabaseConnection databaseConnection;

    public TaxCalculator(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public BigDecimal calculateTax(BigDecimal amount) throws Exception {
        databaseConnection.beginTransaction();

        if (amount == null) {
            return null;
        }

        BigDecimal tax = amount.multiply(TaxCalculator.DEFAULT_RATE).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        databaseConnection.endTransaction();

        return tax;
    }

}
