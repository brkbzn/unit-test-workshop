package com.kloia.workshop.suite;

import com.kloia.workshop.PrintLogger;
import org.junit.Test;

public class PrintLoggerTest1 {

    @Test
    public void printMessage() throws Exception {
        String message = "Hello World 1";
        PrintLogger printLogger = new PrintLogger(message);
        printLogger.printMessage();
    }

}
