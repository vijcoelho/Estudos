package com.example.apidevs.messaging.producer.payload;

public record ProductPayload(
        ProductType type,
        String email
) {
}
