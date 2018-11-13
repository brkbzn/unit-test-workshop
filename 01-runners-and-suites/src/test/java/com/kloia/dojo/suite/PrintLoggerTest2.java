package com.kloia.dojo.suite;

import com.kloia.dojo.PrintLogger;
import org.junit.Test;

public class PrintLoggerTest2 {

    @Test
    public void printMessageWithError() throws Exception {
        String message = "Hello World 2";
        PrintLogger printLogger = new PrintLogger(message);
        printLogger.printMessageWithError();
    }

}
