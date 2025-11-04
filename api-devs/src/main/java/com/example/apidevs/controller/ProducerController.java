package com.example.apidevs.controller;

import com.example.apidevs.messaging.producer.Producer;
import com.example.apidevs.messaging.producer.payload.ProductPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
@RequiredArgsConstructor
public class ProducerController {
    private final Producer producer;

    @PostMapping
    public void send(@RequestBody final ProductPayload message) {
        producer.sendMessage(message);
    }
}
