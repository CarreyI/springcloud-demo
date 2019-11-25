package com.springcloud.ribbon.controller;

import com.springcloud.ribbon.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer() throws InterruptedException {
        return consumerService.hello();
    }
}
