package com.project.springrabbit.rabbit;

import com.project.springrabbit.service.JsonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
    private final JsonService jsonService;

    @RabbitListener(queues = "minhaFilaJson")
    public void receiveMessage(final Message message) {
        String messageFormat = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("Mensagem recebida: {}", messageFormat);

        jsonService.parseMessageToResponse(message);
    }
}
