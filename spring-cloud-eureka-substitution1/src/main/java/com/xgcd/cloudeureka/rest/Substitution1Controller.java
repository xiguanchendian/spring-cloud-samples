package com.xgcd.cloudeureka.rest;

import com.netflix.discovery.EurekaClient;
import com.xgcd.common.model.dto.HouseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        // BeanConfiguration添加@LoadBalanced注解,此处需要修改为服务提供者名称
        return restTemplate.getForObject("http://eureka-service1/service1/hello", String.class);
    }

    @GetMapping("/infos")
    public Object siteName() {
        return eurekaClient.getInstancesByVipAddress("eureka-substitution1", false);
    }

    @GetMapping("/infos2")
    public Object siteName2() {
        return discoveryClient.getInstances("eureka-substitution1");
    }

    // 调用server1的HouseController中方法
    @GetMapping("/data")
    public HouseInfo getData(@RequestParam("name") String name) {
        return restTemplate.getForObject("http://localhost:8081/house/data?name=" + name, HouseInfo.class);
    }

    @GetMapping("/data/{name}")
    public String getData2(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://localhost:8081/house/data/{name}", String.class, name);
    }

    // getForEntity
    @GetMapping("/data3")
    public HouseInfo getData3(@RequestParam("name") String name) {
        ResponseEntity<HouseInfo> responseEntity = restTemplate.getForEntity("http://localhost:8081/house/data?name=" + name, HouseInfo.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            return responseEntity.getBody();
        }
        return null;
    }

    // postForObject
    @GetMapping("/save")
    public Long add() {
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setCity("上海");
        houseInfo.setRegion("虹口");
        houseInfo.setName("xxx");
        // TODO 报错 https://blog.csdn.net/qq_38835878/article/details/89672351
        Long id = restTemplate.postForObject("http://eureka-service1/house/save", houseInfo, Long.class);
        return id;
    }
}
