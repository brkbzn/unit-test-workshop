package com.kloia.dojo.suite;

import com.kloia.dojo.PrintLogger;
import org.junit.Test;

/*
    TODO write the unit tests for PrintLogger.log() that will be run with JUnitTestSuite
*/
public class PrintLoggerTest1 {

    @Test
    public void shouldLog() throws Exception {
        PrintLogger printLogger = new PrintLogger();
        printLogger.log("Hello World 1");
    }

}
