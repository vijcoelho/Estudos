package com.example.userapi.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AlterarSenhaRequest(
        @NotBlank String email,
        @NotBlank String novaSenha
) {
}
