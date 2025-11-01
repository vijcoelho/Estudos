package com.example.apidevs.messaging.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class Consumer {
    @RabbitListener(queues = "${app.queue.main}")
    public void consumer(final Message message) {
        log.info("Mensagem consumida {}", message);

        final String body = new String(message.getBody(), StandardCharsets.UTF_8);
        log.info("Body: {}", body);
    }
}
