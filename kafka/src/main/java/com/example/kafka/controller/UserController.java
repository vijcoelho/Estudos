package com.example.kafka.controller;

import com.example.kafka.dto.FinalPayload;
import com.example.kafka.dto.InfoPayload;
import com.example.kafka.dto.UserPayload;
import com.example.kafka.messaging.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public void send(@RequestBody final UserPayload request) {
        kafkaProducer.send(FinalPayload.builder()
                        .user(request)
                        .info(InfoPayload.builder()
                                .message("Payload sent")
                                .timestamp(LocalDateTime.now())
                                .build())
                        .build());
    }

}
