package com.kloia.workshop.runner;

import com.kloia.workshop.PrintLogger;
import org.junit.Test;

/*
    TODO write the unit tests for each method of PrintLogger that run with PrintLoggerCustomRunner
*/
public class PrintLoggerTest {

    @Test
    public void printMessage() throws Exception {
        String message = "Hello World 1";
        PrintLogger printLogger = new PrintLogger(message);
        printLogger.printMessage();
    }

    @Test
    public void printMessageWithError() throws Exception {
        String message = "Hello World 2";
        PrintLogger printLogger = new PrintLogger(message);
        printLogger.printMessageWithError();
    }

}