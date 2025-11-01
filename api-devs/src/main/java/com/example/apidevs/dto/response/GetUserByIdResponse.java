package com.example.apidevs.dto.response;

public record GetUserByIdResponse(
        String name,
        String email,
        String password,
        String cpf
) {
}
