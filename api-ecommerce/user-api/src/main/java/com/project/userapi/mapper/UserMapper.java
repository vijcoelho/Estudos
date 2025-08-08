package com.project.userapi.mapper;

import com.project.userapi.dto.request.RegisterRequest;
import com.project.userapi.entity.User;

public class UserMapper {

    public static User map(final RegisterRequest request) {
        return User.builder()
                .fullName(request.fullName())
                .username(request.username())
                .password(request.password())
                .build();
    }
}
