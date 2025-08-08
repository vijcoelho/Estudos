package com.project.userapi.dto.response;

import jakarta.validation.constraints.NotBlank;

public record LoginResponse(
        @NotBlank String token
) {
}
