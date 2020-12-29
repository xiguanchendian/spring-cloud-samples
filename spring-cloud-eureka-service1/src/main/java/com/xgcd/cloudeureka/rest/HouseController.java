package com.xgcd.cloudeureka.rest;

import com.xgcd.common.model.dto.HouseInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/house")
public class HouseController {
    @GetMapping("/data")
    public HouseInfo getData(@RequestParam("name") String name) {
        return new HouseInfo(2L, "北京", "海淀", "花虎沟");
    }

    @GetMapping("/data/{name}")
    public String getData2(@PathVariable("name") String name) {
        return name;
    }

    @PostMapping("/save")
    public Long addData(@RequestBody HouseInfo houseInfo) {
        System.out.println(houseInfo.getName());
        return 1001L;
    }
}
