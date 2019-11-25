package com.springcloud.feign.controller;

import com.springcloud.feign.service.HelloService;
import com.springcloud.feign.service.RefactorService;
import com.springcloud.hello.api.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private RefactorService refactorService;

    @RequestMapping("/feign-consumer")
    public String hello(){
        return helloService.hello();
    }

    @RequestMapping("/feign-consumer1")
    public String hello1(){
        return helloService.hello1("didi");
    }

    @RequestMapping("/feign-consumer2")
    public String hello2() throws InterruptedException {
        User user = new User();
        user.setName("didi");
        user.setAge(22);
        return refactorService.hello1(user);
    }
}
