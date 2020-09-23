package com.xgcd.cloudeureka.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class Service1Controller {

    @GetMapping("/hello")
    public String hello() {
        return "hello, i am service1!";
    }
}
