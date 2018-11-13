package com.kloia.dojo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = HelloController.ENDPOINT)
public class HelloController {

    static final String ENDPOINT = "hello";

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

}
