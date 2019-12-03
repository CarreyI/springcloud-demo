package com.springcloud.stream.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;

public interface SinkOutput {
    @Output(Source.OUTPUT)
    MessageChannel output();
}
