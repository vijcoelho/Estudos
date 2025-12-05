package com.example.kafkadev.controller;

import com.example.kafkadev.producer.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producer")
public class KafkaController {
    private final Producer producer;

    @PostMapping
    public void produce(@RequestParam final String message) {
        producer.send(message);
    }
}
