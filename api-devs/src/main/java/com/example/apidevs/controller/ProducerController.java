package com.example.apidevs.controller;

import com.example.apidevs.messaging.producer.Producer;
import com.example.apidevs.messaging.producer.payload.TestePayload;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {
    private final Producer producer;

    @PostMapping
    public void send(@RequestBody final TestePayload message) {
        producer.sendMessage(message);

    }
}
