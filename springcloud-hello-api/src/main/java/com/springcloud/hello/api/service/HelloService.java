package com.springcloud.hello.api.service;

import com.springcloud.hello.api.dto.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/refactor")
public interface HelloService {

    @RequestMapping("/hello")
    String hello1(@RequestBody User user) throws InterruptedException;
}
