package com.example.apidevs.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdatePasswordRequest(
        @NotBlank String email,
        @NotBlank String newPassword
) {
}
