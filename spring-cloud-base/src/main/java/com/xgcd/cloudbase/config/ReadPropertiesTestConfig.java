package com.xgcd.cloudbase.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@ConfigurationProperties(prefix = "xgcd")
@PropertySource("classpath:/config/readPropertiesTest.properties")
@Data
public class ReadPropertiesTestConfig {
    private String name;
}
