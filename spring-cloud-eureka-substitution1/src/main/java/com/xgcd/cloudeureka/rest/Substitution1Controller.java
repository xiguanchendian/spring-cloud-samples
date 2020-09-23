package com.xgcd.cloudeureka.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/substitution1")
public class Substitution1Controller {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/callHello")
    public String callHello() {
        return restTemplate.getForObject("http://eureka-service1/service1/hello", String.class);
    }
}
