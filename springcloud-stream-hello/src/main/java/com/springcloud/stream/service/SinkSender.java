package com.springcloud.stream.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableBinding({SinkOutput.class})
public class SinkSender {

    @Bean
    @InboundChannelAdapter(value = Sink.INPUT,poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource(){
        return () -> new GenericMessage<>(new Date());
    }

    @Transformer(inputChannel = Sink.INPUT,outputChannel = Sink.INPUT)
    public Object transform(Date message){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(message);
    }

}
