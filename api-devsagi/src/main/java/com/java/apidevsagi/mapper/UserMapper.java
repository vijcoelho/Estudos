package com.java.apidevsagi.mapper;

import com.java.apidevsagi.dto.request.SaveUserRequest;
import com.java.apidevsagi.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User map(final SaveUserRequest request) {
        return new User(
                request.name(),
                request.age(),
                request.email());
    }
}
