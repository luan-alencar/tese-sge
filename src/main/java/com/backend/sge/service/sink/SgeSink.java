package com.backend.sge.service.sink;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SgeSink {
    String BINDING_MAILER = "mailer";

    @Input(SgeSink.BINDING_MAILER)
    SubscribableChannel email();
}
