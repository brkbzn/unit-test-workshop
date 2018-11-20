package com.kloia.dojo.suite;

import com.kloia.dojo.PrintLogger;
import org.junit.Test;

/*
    TODO write the unit tests for PrintLogger.logThrowingError() that will be run with JUnitTestSuite
*/
public class PrintLoggerTest2 {

    @Test
    public void shouldLogThrowingError() throws Exception {
        PrintLogger printLogger = new PrintLogger();
        printLogger.logThrowingError("Hello World 2");
    }

}
