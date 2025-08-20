package com.java.apidevsagi.service;

import com.java.apidevsagi.dto.request.SaveUserRequest;
import com.java.apidevsagi.entity.User;
import com.java.apidevsagi.exception.UserNotFoundInDatabaseException;
import com.java.apidevsagi.mapper.UserMapper;
import com.java.apidevsagi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(final SaveUserRequest request) {
        if (Objects.isNull(request)) {
            return null;
        }

        final User user = UserMapper.map(request);

        return userRepository.save(user);
    }
}
