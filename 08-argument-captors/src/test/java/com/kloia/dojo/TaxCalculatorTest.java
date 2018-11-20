package com.kloia.dojo;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/*
    TODO write unit test for TaxCalculator.calculate()
    Here try to capture all the arguments passed into printLogger
 */
@RunWith(MockitoJUnitRunner.class)
public class TaxCalculatorTest {

    @InjectMocks
    private TaxCalculator taxCalculator;

    @Mock
    private TaxAmountValidator taxAmountValidator;

    @Mock
    private TaxRateRepository taxRateRepository;

    @Mock
    private PrintLogger printLogger;

    @Test
    public void shouldCalculate() throws Exception {
        BigDecimal amount = BigDecimal.valueOf(20);

        when(taxRateRepository.getDefaultTaxRate()).thenReturn(BigDecimal.valueOf(18));

        BigDecimal actual = taxCalculator.calculate(amount);

        ArgumentCaptor<String> printArgumentCaptor = ArgumentCaptor.forClass(String.class);

        verify(taxAmountValidator).validate(amount);
        verify(printLogger, times(2)).log(printArgumentCaptor.capture(), Mockito.eq(true));

        assertThat(actual, comparesEqualTo(BigDecimal.valueOf(3.60)));

        assertThat(printArgumentCaptor.getAllValues(), hasSize(2));
        assertThat(printArgumentCaptor.getAllValues().get(0), equalTo("DefaultTaxRate is 18"));
        assertThat(printArgumentCaptor.getAllValues().get(1), equalTo("ScaledTax is 3.60"));
    }

}