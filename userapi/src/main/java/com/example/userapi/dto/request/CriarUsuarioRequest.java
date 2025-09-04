package com.example.userapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarUsuarioRequest(
        @NotBlank String nome,
        @NotBlank String email,
        @NotBlank String senha,
        @NotNull Integer idade
) {
}
