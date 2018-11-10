package com.kloia.workshop.suite;

import com.kloia.workshop.PrintLogger;
import org.junit.Test;

public class PrintLoggerTest2 {

    @Test
    public void printMessageWithError() throws Exception {
        String message = "Hello World 2";
        PrintLogger printLogger = new PrintLogger(message);
        printLogger.printMessageWithError();
    }

}
