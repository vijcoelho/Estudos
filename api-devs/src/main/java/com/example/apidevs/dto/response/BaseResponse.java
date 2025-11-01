package com.example.apidevs.dto.response;

public record BaseResponse<T>(
        T data
) {
}
