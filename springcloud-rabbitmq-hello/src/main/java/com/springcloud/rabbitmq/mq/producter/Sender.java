package com.springcloud.rabbitmq.mq.producter;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String text = "hello" + new Date();
        System.out.println("sender:"+text);
        this.amqpTemplate.convertAndSend("hello",text);
    }
}
