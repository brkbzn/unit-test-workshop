package com.kloia.dojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

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

        return NumberUtils.scale(tax);
    }

}
