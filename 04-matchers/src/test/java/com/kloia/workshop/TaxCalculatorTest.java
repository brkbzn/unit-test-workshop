package com.kloia.workshop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.Stopwatch;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

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

@RunWith(JUnit4.class)
public class TaxCalculatorTest {

    private static DatabaseConnection DATABASE_CONNECTION;
    private TaxCalculator taxCalculator;

    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Rule
    public Stopwatch stopwatch;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

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
    public void getAvailableTaxes() throws Exception {
        List<String> actual = taxCalculator.getAvailableTaxes();

        assertThat(actual, containsInAnyOrder("KDV", "OTV", "MTV"));
        assertThat(actual, contains("KDV", "MTV", "OTV"));
        assertThat(actual, contains("KDV", "OTV", "MTV"));
        assertThat(actual, hasItems("KDV", "OTV"));

        assertThat(actual, hasItem("MTV"));

        assertThat(actual, hasSize(3));

        assertThat(actual, everyItem(notNullValue(String.class)));
        assertThat(actual, everyItem(not(isEmptyOrNullString())));

        assertThat(actual, allOf(instanceOf(String.class)));
    }

    @Test
    public void getTaxUsage() throws Exception {
        Map<String, Boolean> actual = taxCalculator.getTaxUsage();

        assertThat(actual, hasEntry("KDV", true));

        assertThat(actual, hasKey("MTV"));

        assertThat(actual, instanceOf(Map.class));
        assertThat(actual, isA(Map.class));

        assertThat(actual, anyOf(hasValue(true)));
    }

    @Test
    public void testBigDecimal() throws Exception {
        BigDecimal actual = taxCalculator.getTaxRate();

        assertThat(actual, closeTo(BigDecimal.valueOf(18), BigDecimal.valueOf(0)));
        assertThat(actual, comparesEqualTo(BigDecimal.valueOf(18.000)));
        assertThat(actual, lessThan(BigDecimal.valueOf(20)));
    }


    @Test
    public void shouldTest1() throws Exception {
        File asasas = temporaryFolder.newFile("asasas");
        temporaryFolder.create();
    }
}