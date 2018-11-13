package com.kloia.dojo.runner;

import com.kloia.dojo.PrintLogger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/*
    TODO write the unit tests for each method of PrintLogger that run with JUnit4 runner.
*/
@RunWith(JUnit4.class)
public class PrintLoggerTestWithJUnit4Runner {


    @Test
    public void printMessage() throws Exception {
        String message = "Hello World 1";
        PrintLogger printLogger = new PrintLogger(message);
        printLogger.printMessage();
    }

}
