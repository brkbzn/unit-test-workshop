package com.kloia.dojo.runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class PrintLoggerCustomRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PrintLoggerTest.class);

        if (result.wasSuccessful()) {
            System.out.println("Test result is successful.");
            return;
        }

        System.err.println("Testing failed. There are " + result.getFailureCount() + " failures.");

        for (Failure failure : result.getFailures()) {
            System.err.println("Failure: " + failure.toString() + ", " + failure.getTrace());

        }
    }
}
