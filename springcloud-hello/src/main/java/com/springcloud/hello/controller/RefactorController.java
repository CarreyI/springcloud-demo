package com.springcloud.hello.controller;

import com.springcloud.hello.api.dto.User;
import com.springcloud.hello.api.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RefactorController implements HelloService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public String hello1(@RequestBody User user) throws InterruptedException {
        int sleepTime = new Random().nextInt(3000);
        logger.info(String.valueOf(sleepTime));
        Thread.sleep(sleepTime);
        return "Hello!"+user.getName()+":"+user.getAge();
    }
}
