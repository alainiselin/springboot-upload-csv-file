package com.alankoder.springbootuploadcsvfile.controller;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestGreetingRestController {

    @PostMapping("/greeting")
    public String getGreeting() {
        return "TestGreeting Test change 01";
    }

}
