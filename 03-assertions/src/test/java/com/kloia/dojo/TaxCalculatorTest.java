package com.kloia.dojo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

/*
    TODO write unit tests for tax calculator methods
    This time, you should assert the equalities of the return values of all methods.

    Example test cases for "BigDecimal getTaxRate()"
        - Returned value equals to 18
        - Returned object is not equal to (same object reference) BigDecimal.valueOf(18)

    Example test cases for "String getDefaultTaxType()"
        - Returned value equals to default tax
        - Returned object is equal to (same object reference) "KDV"

    Example test cases for "List<String> getAvailableTaxes()"
        - Returned list's values equal to list of tax arrays
        - But not object reference equality

    Example test cases for "BigDecimal calculate()"
        - Returned value is null when amount is null
        - Checking values and object references of BigDecimal values
*/
@RunWith(JUnit4.class)
public class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    @Before
    public void setUp() throws Exception {
        taxCalculator = new TaxCalculator();
    }

    @After
    public void tearDown() throws Exception {
        taxCalculator = null;
    }

    @Test
    public void shouldGetTaxRate() throws Exception {
        BigDecimal actual = taxCalculator.getTaxRate();

        assertEquals(BigDecimal.valueOf(18), actual);
        assertNotSame(BigDecimal.valueOf(18), actual);
    }

    @Test
    public void shouldGetDefaultTaxType() throws Exception {
        String actual = taxCalculator.getDefaultTaxType();

        assertEquals("KDV", actual);
        assertSame("KDV", actual);
    }

    @Test
    public void shouldGetAvailableTaxes() throws Exception {
        List<String> actual = taxCalculator.getAvailableTaxes();

        List<String> expected = Arrays.asList("KDV", "OTV", "MTV");

        assertEquals(expected, actual);
        assertNotSame(expected, actual);
    }

    @Test
    public void shouldCalculate() throws Exception {
        BigDecimal actual = taxCalculator.calculate(BigDecimal.valueOf(100), false);

        assertEquals(BigDecimal.valueOf(18).setScale(2, RoundingMode.HALF_UP), actual);
    }

    @Test
    public void shouldCalculateWithRounding() throws Exception {
        BigDecimal actual = taxCalculator.calculate(BigDecimal.valueOf(10), false);

        assertEquals(BigDecimal.valueOf(1.8).setScale(2, RoundingMode.HALF_UP), actual);
        assertNotSame(BigDecimal.valueOf(1.8).setScale(2, RoundingMode.HALF_UP), actual);
    }

    @Test
    public void shouldCalculateWithDiscount() throws Exception {
        BigDecimal actual = taxCalculator.calculate(BigDecimal.valueOf(10), true);

        assertEquals(BigDecimal.valueOf(0.8).setScale(2, RoundingMode.HALF_UP), actual);
    }

    @Test
    public void shouldCalculateNull() throws Exception {
        BigDecimal actual = taxCalculator.calculate(null, false);

        assertNull(actual);
        assertSame(null, actual);
    }


}