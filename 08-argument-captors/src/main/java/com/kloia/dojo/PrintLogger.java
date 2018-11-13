package com.kloia.dojo;

import org.springframework.stereotype.Component;

@Component
public class PrintLogger {

    public void log(String message, boolean debugEnabled) {
        if (debugEnabled) {
            System.out.println(message);
        }
    }

}
