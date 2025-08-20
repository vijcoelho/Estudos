package com.java.apidevsagi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SaveUserRequest(
        @NotBlank String name,
        @NotNull Integer age,
        @NotBlank String email
) {
}