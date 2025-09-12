package com.example.kafka.dto;

import lombok.Builder;

@Builder
public record FinalPayload(
        UserPayload user,
        InfoPayload info
) {
}
