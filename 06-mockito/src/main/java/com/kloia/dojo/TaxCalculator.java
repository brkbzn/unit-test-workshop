package com.kloia.dojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TaxCalculator {

    private final TaxRateRepository taxRateRepository;
    private final TaxAmountValidator taxAmountValidator;

    @Autowired
    public TaxCalculator(TaxRateRepository taxRateRepository, TaxAmountValidator taxAmountValidator) {
        this.taxRateRepository = taxRateRepository;
        this.taxAmountValidator = taxAmountValidator;
    }

    public BigDecimal calculate(BigDecimal amount) throws TaxAmountException {
        taxAmountValidator.validate(amount);

        BigDecimal defaultTaxRate = taxRateRepository.getDefaultTaxRate();

        BigDecimal tax = amount.multiply(defaultTaxRate).divide(BigDecimal.valueOf(100));

        return scale(tax);
    }

    private BigDecimal scale(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP);
    }

}
