package com.kloia.dojo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

/*
    TODO write unit tests for tax calculator with different inputs that print the results to the System.out
    Before initializing the tax calculator make sure that the DatabaseConnection is established.
    You may try to run your test in specified order
    Also you can try timeout of your test. Ignorance of a test would be an option though.
*/
@RunWith(JUnit4.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
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
        taxCalculator = new TaxCalculator(DATABASE_CONNECTION);
    }

    @After
    public void tearDown() throws Exception {
        taxCalculator = null;
    }

    @Test
    public void shouldCalculate() throws Exception {
        BigDecimal actual = taxCalculator.calculateTax(BigDecimal.valueOf(100));

        System.out.println(actual);
    }

    @Test
    public void shouldCalculateNull() throws Exception {
        BigDecimal actual = taxCalculator.calculateTax(null);

        System.out.println(actual);
    }

    @Test(timeout = 3)
    @Ignore
    public void shouldCalculateWithTimeout() throws Exception {
        for (int i = 0; i < 100_000; i++) {
            taxCalculator.calculateTax(BigDecimal.valueOf(-100));
        }
    }

}