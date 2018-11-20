package com.kloia.dojo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/*
    TODO write unit tests for TestCalculator methods
    Example assertions for "List<String> getAvailableTaxes()"
        - List contains elements in any order
        - List contains elements in specified order
        - List contains one or more elements
        - Size of list
        - Checking all the list items are non-null
        - Checking all the list items are instance of String

    Example assertions for "Map<String, Boolean> getAvailableTaxes()"
        - Return value is an instance of Map
        - There is an entry with key "MTV"
        - There is an entry "[KDV, true]"
        - There is at least one entry having "true" value
        - All the entries has non-null values

    Example assertions for "BigDecimal getTaxRate()"
        - Checking the value equals to 18(or 18.000) without specifying the scale
        - Checking the value is lessThan 20

 */
@RunWith(JUnit4.class)
public class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    @Before
    public void setUp() throws Exception {
        taxCalculator = new TaxCalculator();
    }

    @Test
    public void shouldGetAvailableTaxes() throws Exception {
        List<String> actual = taxCalculator.getAvailableTaxes();

        assertThat(actual, containsInAnyOrder("KDV", "OTV", "MTV"));
        assertThat(actual, not(contains("KDV", "MTV", "OTV")));
        assertThat(actual, contains("KDV", "OTV", "MTV"));
        assertThat(actual, hasItems("KDV", "OTV"));

        assertThat(actual, hasItem("MTV"));

        assertThat(actual, hasSize(3));

        assertThat(actual, isA(List.class));
        assertThat(actual, instanceOf(List.class));

        assertThat(actual, everyItem(notNullValue(String.class)));
        assertThat(actual, everyItem(not(isEmptyOrNullString())));
        assertThat(actual, everyItem(instanceOf(String.class)));
    }

    @Test
    public void shouldGetTaxUsage() throws Exception {
        Map<String, Boolean> actual = taxCalculator.getTaxUsage();

        assertThat(actual, hasEntry("KDV", true));

        assertThat(actual, hasKey("MTV"));

        assertThat(actual, instanceOf(Map.class));
        assertThat(actual, isA(Map.class));

        assertThat(actual, anyOf(hasValue(true)));
    }

    @Test
    public void shouldGetTaxRate() throws Exception {
        BigDecimal actual = taxCalculator.getTaxRate();

        assertThat(actual, closeTo(BigDecimal.valueOf(18), BigDecimal.valueOf(0)));
        assertThat(actual, comparesEqualTo(BigDecimal.valueOf(18.000)));
        assertThat(actual, lessThan(BigDecimal.valueOf(20)));
    }


}