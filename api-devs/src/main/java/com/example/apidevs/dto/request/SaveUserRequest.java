package com.example.apidevs.dto.request;

import jakarta.validation.constraints.NotBlank;

public record SaveUserRequest(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String password,
        @NotBlank String cpf
) {
}
