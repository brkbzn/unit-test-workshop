package com.kloia.workshop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

/*
 TODO write unit tests for tax calculator with different inputs
 Before initializing the tax calculator make sure that the DatabaseConnection is established.
*/
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
        taxCalculator = new TaxCalculator(DATABASE_CONNECTION);
    }

    @After
    public void tearDown() throws Exception {
        taxCalculator = null;
    }

    @Test
    public void test1() throws Exception {
        BigDecimal actual = taxCalculator.calculateTax(BigDecimal.valueOf(100));

        System.out.println(actual);
    }

    @Test
    public void test2() throws Exception {
        BigDecimal actual = taxCalculator.calculateTax(null);

        System.out.println(actual);
    }

}