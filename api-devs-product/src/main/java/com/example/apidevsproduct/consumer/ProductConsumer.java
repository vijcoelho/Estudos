package com.example.apidevsproduct.consumer;

import com.example.apidevsproduct.consumer.payload.ProductPayload;
import com.example.apidevsproduct.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ProductConsumer {
    private final ObjectMapper objectMapper;
    private final ProductService productService;

    @RabbitListener(queues = "${app.queue.consumer}")
    public void consumer(final Message message) {
//        log.info("Mensagem: {}", message);
//
//        final String body = new String(message.getBody(), StandardCharsets.UTF_8);
//        log.info("Mensagem String: {}", body);

        final ProductPayload payload = parse(message);
        log.info("Mensagem de Obj: {}", payload);

        productService.save(payload);
    }

    private ProductPayload parse(final Message message) {
        try {
            return objectMapper.readValue(message.getBody(), ProductPayload.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
