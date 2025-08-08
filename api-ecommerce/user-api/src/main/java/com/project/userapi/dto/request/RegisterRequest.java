package com.project.userapi.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @NotBlank String fullName,
        @NotBlank String username,
        @NotBlank String password
) {
}
