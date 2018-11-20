package com.kloia.dojo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/*
    TODO write unit tests for taxCalculator.calculate() by mocking the taxAmountValidator, taxRateRepository, as well as mocking static NumberUtils.scale() method
    After invoking the method, don't forget to the assertions as well as verifications.

    Example test cases:
        - taxAmountValidator throws no exception, taxRepository returns values.
        - taxAmountValidator throws exception.

 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({NumberUtils.class})
public class TaxCalculatorTest {

    @InjectMocks
    private TaxCalculator taxCalculator;

    @Mock
    private TaxAmountValidator taxAmountValidator;

    @Mock
    private TaxRateRepository taxRateRepository;

    @Test
    public void shouldCalculate() throws Exception {
        PowerMockito.mockStatic(NumberUtils.class);

        BigDecimal amount = BigDecimal.valueOf(20);

        when(taxRateRepository.getDefaultTaxRate()).thenReturn(BigDecimal.valueOf(18));
        PowerMockito.when(NumberUtils.scale(BigDecimal.valueOf(3.6))).thenReturn(BigDecimal.valueOf(666));

        BigDecimal actual = taxCalculator.calculate(amount);

        verify(taxAmountValidator).validate(amount);
        PowerMockito.verifyStatic();

        assertThat(actual, equalTo(BigDecimal.valueOf(666)));
    }

    @Test
    public void shouldNotCalculateWhenValidatorThrowsException() throws Exception {
        PowerMockito.mockStatic(NumberUtils.class);

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

        PowerMockito.verifyStatic(never());
    }
}