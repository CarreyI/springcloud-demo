package com.springcloud.feign.service.fallback;

import com.springcloud.feign.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello1( String name) {
        return "error:"+name;
    }
}
