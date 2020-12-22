package com.xgcd.cloudeureka.rest;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/callHello")
    public String callHello() {
//        return restTemplate.getForObject("http://localhost:8081/service1/hello", String.class);
        return restTemplate.getForObject("http://eureka-service1/service1/hello", String.class);// BeanConfiguration添加@LoadBalanced注解,此处修改为服务提供者名称
    }

    @GetMapping("/infos")
    public Object siteName() {
        return eurekaClient.getInstancesByVipAddress("eureka-substitution1", false);
    }

    @GetMapping("/infos2")
    public Object siteName2(){
        return discoveryClient.getInstances("eureka-substitution1");
    }
}
