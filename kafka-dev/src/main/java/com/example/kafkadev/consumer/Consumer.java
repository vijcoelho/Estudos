package com.example.kafkadev.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @KafkaListener(topics = "${app.kafka-topic.topic-1}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final String message) {
        log.info("Consumindo a mensagem: {}", message);
    }
}
