package com.kloia.workshop;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

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


    @Test(expected = IllegalArgumentException.class)
    public void shouldTest2() throws Exception {
        taxCalculator = new TaxCalculator();

        taxCalculator.calculate(BigDecimal.valueOf(-20));
    }

    @Test
    public void shouldTest3() throws Exception {
        taxCalculator = new TaxCalculator();

        try {
            taxCalculator.calculate(BigDecimal.valueOf(-20));
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
            assertThat(e.getMessage(), equalTo("Amount cannot be negative"));
        }
    }

}