package com.kloia.dojo;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TaxRateRepository {

    BigDecimal getDefaultTaxRate();
}
