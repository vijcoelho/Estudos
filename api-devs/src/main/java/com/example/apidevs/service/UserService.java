package com.example.apidevs.service;

import com.example.apidevs.dto.request.SaveUserRequest;
import com.example.apidevs.dto.request.UpdatePasswordRequest;
import com.example.apidevs.dto.response.GetUserByIdResponse;
import com.example.apidevs.dto.response.SaveUserResponse;
import com.example.apidevs.dto.response.UpdatePasswordResponse;
import com.example.apidevs.entities.User;
import com.example.apidevs.exceptions.RequestIsNullException;
import com.example.apidevs.exceptions.UserNotFoundException;
import com.example.apidevs.mapper.UserMapper;
import com.example.apidevs.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public SaveUserResponse save(final SaveUserRequest request) {
        if (Objects.isNull(request)) {
            throw new RequestIsNullException();
        }

        final User user = UserMapper.map(request);
        userRepository.save(user);

        return new SaveUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public GetUserByIdResponse getById(final String id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario nao encontrado pelo Id"));

        final GetUserByIdResponse response = UserMapper.toResponse(user);

        return response;
    }

    public UpdatePasswordResponse updatePassword(final UpdatePasswordRequest request) {
        if (Objects.isNull(request)) {
            throw new RequestIsNullException();
        }

        final User user = userRepository.findUserByEmail(request.email())
                .orElseThrow(() -> new UserNotFoundException("Usuario nao encontrado pelo Email"));
        user.setPassword(request.newPassword());
        userRepository.save(user);

        return new UpdatePasswordResponse(user.getPassword());
    }

    public void delete(final String id) {
        userRepository.deleteById(id);
    }
}
