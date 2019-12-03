package com.springcloud.stream.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding({Sink.class})
public class SinkReceiver {

//    @StreamListener(Sink.INPUT)
    @ServiceActivator(inputChannel = Sink.INPUT)
//    @SendTo(Processor.OUTPUT)
    public void receive(Object payload){
        System.out.println(payload.toString());
    }
}
