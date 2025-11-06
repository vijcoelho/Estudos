package com.example.apidevsproduct.consumer.payload;

public record ProductPayload(
        ProductType type,
        String email
) {
}
