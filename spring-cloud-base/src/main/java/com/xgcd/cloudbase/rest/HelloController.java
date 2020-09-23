package com.xgcd.cloudbase.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello Spring Cloud Base!";
    }
}
