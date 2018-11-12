package com.kloia.workshop;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.math.BigDecimal;

/*
  TODO write the unit tests for TaxCalculator.calculate()
  Try to test exception cases by using different exception handling strategies.
  Try to test exception messages if you can
*/
@RunWith(JUnit4.class)
public class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldTest1() throws Exception {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Amount cannot be null");

        taxCalculator = new TaxCalculator();

        taxCalculator.calculate(null);
    }


    @Test(expected = IOException.class)
    public void shouldCalculateWithoutDbConnection() throws Exception {
        taxCalculator = new TaxCalculator();

        taxCalculator.calculate(BigDecimal.valueOf(100));
    }
}