package com.example.kafka.messaging;

import com.example.kafka.dto.FinalPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, FinalPayload> kafkaTemplate;

    public void send(final FinalPayload payload) {
        this.kafkaTemplate.send("user.topic", payload);
    }

}
