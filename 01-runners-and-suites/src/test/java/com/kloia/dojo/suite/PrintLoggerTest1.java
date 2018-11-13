package com.kloia.dojo.suite;

import com.kloia.dojo.PrintLogger;
import org.junit.Test;

public class PrintLoggerTest1 {

    @Test
    public void printMessage() throws Exception {
        String message = "Hello World 1";
        PrintLogger printLogger = new PrintLogger(message);
        printLogger.printMessage();
    }

}
