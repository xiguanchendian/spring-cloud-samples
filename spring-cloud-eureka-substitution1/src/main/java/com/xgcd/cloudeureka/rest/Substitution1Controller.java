package com.xgcd.cloudeureka.rest;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;
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

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/callHello")
    public String callHello() {
        return restTemplate.getForObject("http://localhost:8081/service1/hello", String.class);// BeanConfiguration添加@LoadBalanced注解,此处修改为服务提供者名称报错
    }

    @GetMapping("/infos")
    public Object siteName() {
        // TODO security认证失败,用户名或密码错误
        return eurekaClient.getInstancesByVipAddress("eureka-substitution1", false);
    }
}
