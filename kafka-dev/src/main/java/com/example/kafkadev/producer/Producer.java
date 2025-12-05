package com.example.kafkadev.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Producer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.kafka-topic.topic-1}")
    private String topic;

    public void send(final String message) {
        this.kafkaTemplate.send(topic, message);
    }
}
