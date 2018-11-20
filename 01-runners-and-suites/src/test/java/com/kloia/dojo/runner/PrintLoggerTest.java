package com.kloia.dojo.runner;

import com.kloia.dojo.PrintLogger;
import org.junit.Test;

/*
    TODO write the unit tests for each method of PrintLogger that run with PrintLoggerCustomRunner
*/
public class PrintLoggerTest {

    @Test
    public void shouldLog() throws Exception {
        PrintLogger printLogger = new PrintLogger();
        printLogger.log("Hello World 1");
    }

    @Test
    public void shouldLogThrowingError() throws Exception {
        PrintLogger printLogger = new PrintLogger();
        printLogger.logThrowingError("Hello World 2");
    }

}