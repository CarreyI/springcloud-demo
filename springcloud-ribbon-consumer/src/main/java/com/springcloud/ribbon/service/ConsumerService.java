package com.springcloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Service
public class ConsumerService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand(fallbackMethod = "back")
    public String hello() throws InterruptedException {
        int sleepTime = new Random().nextInt(3000);
        logger.info(String.valueOf(sleepTime));
        Thread.sleep(sleepTime);
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }

    public String back(){
        return "error";
    }
}
