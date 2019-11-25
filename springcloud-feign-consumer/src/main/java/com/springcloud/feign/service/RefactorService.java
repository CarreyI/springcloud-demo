package com.springcloud.feign.service;

import com.springcloud.hello.api.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("hello-service")
public interface RefactorService extends HelloService {
}
