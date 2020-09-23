package com.xgcd.cloudbase.rest;

import com.xgcd.cloudbase.config.ReadPropertiesTestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("readProperties")
@EnableConfigurationProperties(ReadPropertiesTestConfig.class)
public class ReadPropertiesController {

    @Autowired
    private Environment environment;

    @Value("${server.port}")
    private String port;

    @Autowired
    private ReadPropertiesTestConfig readPropertiesTestConfig;

    @GetMapping("/byEnvironment")
    public String byEnvironment() {
        String port = environment.getProperty("server.port");
        return "byEnvironment:" + port;
    }

    @GetMapping("/byValue")
    public String byValue() {
        return "byValue:" + port;
    }

    @GetMapping("byConfig")
    public String byConfig() {
        return "byConfig:" + readPropertiesTestConfig.getName();
    }
}
