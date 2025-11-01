package com.example.apidevs.messaging.producer;

import com.example.apidevs.messaging.producer.payload.TestePayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class Producer {
    private final RabbitTemplate rabbitTemplate;

    @Value("${app.queue.main}")
    private String queue;

    public void sendMessage(final TestePayload message) {
        log.info("Iniciando producer com a mensagem {}", message);

        try {
            rabbitTemplate.convertAndSend(queue, message);
            log.info("Mensagem enviada para a fila com sucesso!");
        } catch (AmqpException e) {
            log.error("Erro ao enviar mensagem {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
