package com.kloia.dojo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

    public static BigDecimal scale(BigDecimal value) {
        return value.setScale(2, RoundingMode.HALF_UP);
    }

}
