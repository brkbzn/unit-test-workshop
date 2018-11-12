package com.kloia.workshop;

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
 When checking equalities, you should try to check both instance and value equalities.
 java.lang.String is a good class to do that.
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
    public void test1() throws Exception {
        BigDecimal actual = taxCalculator.getTaxRate();

        assertEquals(BigDecimal.valueOf(18), actual);
        assertNotSame(BigDecimal.valueOf(18), actual);
    }

    @Test
    public void test2() throws Exception {
        String actual = taxCalculator.getDefaultTaxType();

        assertEquals("KDV", actual);
        assertSame("KDV", actual);
    }

    @Test
    public void test3() throws Exception {
        List<String> actual = taxCalculator.getAvailableTaxes();

        List<String> expected = Arrays.asList("KDV", "OTV", "MTV");

        assertEquals(expected, actual);
        assertNotSame(expected, actual);
    }

    @Test
    public void test4() throws Exception {
        BigDecimal actual = taxCalculator.calculate(BigDecimal.valueOf(100), false);

        assertEquals(BigDecimal.valueOf(18).setScale(2, RoundingMode.HALF_UP), actual);
    }

    @Test
    public void test5() throws Exception {
        BigDecimal actual = taxCalculator.calculate(BigDecimal.valueOf(10), false);

        assertEquals(BigDecimal.valueOf(1.8).setScale(2, RoundingMode.HALF_UP), actual);
        assertNotSame(BigDecimal.valueOf(1.8).setScale(2, RoundingMode.HALF_UP), actual);
    }

    @Test
    public void test6() throws Exception {
        BigDecimal actual = taxCalculator.calculate(BigDecimal.valueOf(10), true);

        assertEquals(BigDecimal.valueOf(0.8).setScale(2, RoundingMode.HALF_UP), actual);
    }

    @Test
    public void test7() throws Exception {
        BigDecimal actual = taxCalculator.calculate(null, false);

        assertNull(actual);
        assertSame(null, actual);
    }


}