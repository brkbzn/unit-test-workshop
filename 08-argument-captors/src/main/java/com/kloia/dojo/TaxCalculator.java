package com.kloia.dojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TaxCalculator {

    private final TaxRateRepository taxRateRepository;
    private final TaxAmountValidator taxAmountValidator;
    private final PrintLogger printLogger;

    @Autowired
    public TaxCalculator(TaxRateRepository taxRateRepository, TaxAmountValidator taxAmountValidator, PrintLogger printLogger) {
        this.taxRateRepository = taxRateRepository;
        this.taxAmountValidator = taxAmountValidator;
        this.printLogger = printLogger;
    }

    public BigDecimal calculate(BigDecimal amount) throws TaxAmountException {
        taxAmountValidator.validate(amount);

        BigDecimal defaultTaxRate = taxRateRepository.getDefaultTaxRate();

        printLogger.log("DefaultTaxRate is " + defaultTaxRate, true);

        BigDecimal tax = amount.multiply(defaultTaxRate).divide(BigDecimal.valueOf(100));

        BigDecimal scaledTax = NumberUtils.scale(tax);

        printLogger.log("ScaledTax is " + scaledTax, true);

        return scaledTax;
    }

}
