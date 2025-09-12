package com.example.kafka.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserPayload(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String password,
        @NotNull Integer age
) {
}
