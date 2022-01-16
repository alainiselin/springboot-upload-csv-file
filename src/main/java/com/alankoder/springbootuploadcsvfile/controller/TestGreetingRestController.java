package com.alankoder.springbootuploadcsvfile.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestGreetingRestController {

    @GetMapping("/greeting")
    public String getGreeting() {
        return "D Sarina isch horny uf de Ally Law";
    }

}
