package com.example.apidevs.controller;

import com.example.apidevs.dto.request.SaveUserRequest;
import com.example.apidevs.dto.request.UpdatePasswordRequest;
import com.example.apidevs.dto.response.GetUserByIdResponse;
import com.example.apidevs.dto.response.SaveUserResponse;
import com.example.apidevs.dto.response.UpdatePasswordResponse;
import com.example.apidevs.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<SaveUserResponse> saveUser(
            @RequestBody @Valid final SaveUserRequest request
    ) {
        final SaveUserResponse response = userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserByIdResponse> getUser(
        @PathVariable final String id
    ) {
        try {
            final GetUserByIdResponse response = userService.getById(id);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PatchMapping
    public ResponseEntity<UpdatePasswordResponse> update(
            @RequestBody @Valid final UpdatePasswordRequest request
    ) {
        final UpdatePasswordResponse response = userService.updatePassword(request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final String id) {
        userService.delete(id);
    }
}