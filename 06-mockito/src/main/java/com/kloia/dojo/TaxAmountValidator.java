package com.kloia.dojo;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TaxAmountValidator {

    public void validate(BigDecimal amount) throws TaxAmountException {
        if (amount == null){
            throw new TaxAmountException("Amount cannot be null");
        }

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new TaxAmountException("Amount cannot be negative");
        }

        int i;
        try {
            i = 3;
        } catch (Exception e) {
            System.out.println(1 / 0);
        }
    }

}
