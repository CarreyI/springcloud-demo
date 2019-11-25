package com.springcloud.hello.controller;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private EurekaInstanceConfig config;

    @RequestMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    @RequestMapping("/hello1")
    public String hello1(@RequestParam String name){
        return name;
    }
}
