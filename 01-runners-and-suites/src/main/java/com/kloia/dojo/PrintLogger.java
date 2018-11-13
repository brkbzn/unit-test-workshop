package com.kloia.dojo;

public class PrintLogger {

    private String message;

    public PrintLogger(String message) {
        this.message = message;
    }

    public String printMessage() throws Exception {
        System.out.println(message);

        return message;
    }

    public String printMessageWithError() throws Exception {
        System.out.println(message);

        return message + String.valueOf(1 / 0);
    }

}
