package com.kloia.dojo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxCalculator {

    private static final BigDecimal DEFAULT_TAX_RATE = BigDecimal.valueOf(18);
    private static final List<String> AVAILABLE_TAXES = Arrays.asList("KDV", "OTV", "MTV");
    private static final Map<String, Boolean> TAX_USAGE = new HashMap<>();

    static {
        TAX_USAGE.put("KDV", true);
        TAX_USAGE.put("OTV", false);
        TAX_USAGE.put("MTV", false);
    }

    public List<String> getAvailableTaxes() {
        return AVAILABLE_TAXES;
    }

    public Map<String, Boolean> getTaxUsage() {
        return TAX_USAGE;
    }


    public BigDecimal getTaxRate() {
        return DEFAULT_TAX_RATE;
    }

}
