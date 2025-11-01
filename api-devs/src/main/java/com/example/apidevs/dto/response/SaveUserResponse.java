package com.example.apidevs.dto.response;

public record SaveUserResponse(
        String id,
        String name,
        String email
) {
}