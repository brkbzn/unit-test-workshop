package com.kloia.dojo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/*
    TODO write unit tests for taxCalculator.calculate() by mocking the taxAmountValidator and taxRateRepository
    After invoking the method, don't forget to the assertions as well as verifications.

    Example test cases:
        - taxAmountValidator throws no exception, taxRepository returns values.
        - taxAmountValidator throws exception.

 */
@RunWith(MockitoJUnitRunner.class)
public class TaxCalculatorTest {

    @InjectMocks
    private TaxCalculator taxCalculator;

    @Mock
    private TaxAmountValidator taxAmountValidator;

    @Mock
    private TaxRateRepository taxRateRepository;

    @Test
    public void shouldCalculate() throws Exception {
        BigDecimal amount = BigDecimal.valueOf(20);
        when(taxRateRepository.getDefaultTaxRate()).thenReturn(BigDecimal.valueOf(18));

        BigDecimal actual = taxCalculator.calculate(amount);


        verify(taxAmountValidator).validate(amount);

        assertThat(actual, comparesEqualTo(BigDecimal.valueOf(3.6)));
    }

    @Test
    public void shouldNotCalculateWhenValidatorThrowsException() throws Exception {
        BigDecimal amount = BigDecimal.valueOf(20);

        doThrow(TaxAmountException.class).when(taxAmountValidator).validate(amount);

        try {
            taxCalculator.calculate(amount);
        } catch (Exception e) {
            assertThat(e, instanceOf(TaxAmountException.class));
        }

        verify(taxAmountValidator).validate(amount);
        verifyZeroInteractions(taxRateRepository);
        verify(taxRateRepository, never()).getDefaultTaxRate();
        verify(taxRateRepository, times(0)).getDefaultTaxRate();
    }
}