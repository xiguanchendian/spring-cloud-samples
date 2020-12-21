package com.xgcd.cloudeureka.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    @LoadBalanced// 自动构造LoadBalancedClient接口的实现类并注册到Spring容器中
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
