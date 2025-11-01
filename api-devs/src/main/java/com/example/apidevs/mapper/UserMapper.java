package com.example.apidevs.mapper;

import com.example.apidevs.dto.request.SaveUserRequest;
import com.example.apidevs.dto.response.GetUserByIdResponse;
import com.example.apidevs.entities.User;

public class UserMapper {

    public static User map(final SaveUserRequest request) {
        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .cpf(request.cpf())
                .build();
    }

    public static GetUserByIdResponse toResponse(final User user) {
        return new GetUserByIdResponse(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCpf()
        );
    }
}
