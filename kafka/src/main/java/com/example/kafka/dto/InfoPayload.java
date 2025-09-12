package com.example.kafka.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record InfoPayload(
        String message,
        LocalDateTime timestamp
) {
}
