package com.kloia.workshop;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TaxRateRepository {

    BigDecimal getDefaultTaxRate();
}
