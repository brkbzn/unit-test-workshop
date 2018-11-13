package com.kloia.dojo;

public class PrintLogger {


    public void log(String message) throws Exception {
        System.out.println(message);
    }

    public void logThrowingError(String message) throws Exception {
        System.out.println(message);

        System.out.println(message + String.valueOf(1/0));
    }

}
