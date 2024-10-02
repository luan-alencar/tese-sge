package com.backend.sge.service;


import com.backend.sge.domain.dto.EmailDTO;
import com.backend.sge.service.sink.SgeSink;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@EnableBinding(SgeSink.class)
public class RabbitService {

    private final EmailService emailServico;

    @StreamListener(target = SgeSink.BINDING_MAILER)
    public void sendMail(@Payload EmailDTO emailDTO) {
        emailServico.sendMail(emailDTO);
    }
}