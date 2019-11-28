package com.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class Application {
//
//    @Bean
//    public AccessFilter accessFilter(){
//        return new AccessFilter();
//    }

    @Bean
    @RefreshScope
    @ConfigurationProperties("zuul")
    @Primary
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }

//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper(){
//        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)","${version}/${name}");
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
