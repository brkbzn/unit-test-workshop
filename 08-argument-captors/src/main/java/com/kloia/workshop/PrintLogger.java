package com.kloia.workshop;

import org.springframework.stereotype.Component;

@Component
public class PrintLogger {

    public void log(String message, boolean debugEnabled) {
        System.out.println(message);
    }

}
