package com.kloia.workshop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

// TODO write unit tests for tax calculator
// Before initializing the tax calculator make sure that the DatabaseConnection is established.
//
@RunWith(JUnit4.class)
public class TaxCalculatorTest {

    private static DatabaseConnection DATABASE_CONNECTION;
    private TaxCalculator taxCalculator;

    @BeforeClass
    public static void beforeClass() throws Exception {
        DATABASE_CONNECTION = new DatabaseConnection();
        DATABASE_CONNECTION.open();

        System.out.println("db connection opened");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        DATABASE_CONNECTION.close();

        System.out.println("db connection closed");
    }

    @Before
    public void setUp() throws Exception {
        assertTrue(DATABASE_CONNECTION.isOpen());
        taxCalculator = new TaxCalculator(DATABASE_CONNECTION);
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
    }

    @Test
    public void test4() throws Exception {
        BigDecimal actual = taxCalculator.calculate(BigDecimal.valueOf(100), false);

        assertEquals(actual, BigDecimal.valueOf(18));
    }

    @Test
    public void test5() throws Exception {
        BigDecimal actual = taxCalculator.calculate(BigDecimal.valueOf(10), false);

        assertEquals(actual, BigDecimal.valueOf(1.8));
    }

    @Test
    public void test6() throws Exception {
        BigDecimal actual = taxCalculator.calculate(BigDecimal.valueOf(10), true);

        assertEquals(actual, BigDecimal.valueOf(0.80));
    }

    @Test
    public void test7() throws Exception {
        BigDecimal actual = taxCalculator.calculate(null, false);

        assertNull(actual);
    }


}