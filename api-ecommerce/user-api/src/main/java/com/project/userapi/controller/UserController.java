package com.project.userapi.controller;

import com.project.userapi.dto.request.LoginRequest;
import com.project.userapi.dto.request.RegisterRequest;
import com.project.userapi.dto.response.LoginResponse;
import com.project.userapi.entity.User;
import com.project.userapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid final RegisterRequest request) {
        try {
            userService.save(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Register Successfully!");
        } catch (Exception e) {
            throw new RuntimeException("Error in controller to call save() method");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid final LoginRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(userService.login(request));
        } catch (Exception e) {
            throw new RuntimeException("Error in controller to call login() method.");
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> get(@PathVariable final String username) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(userService.get(username));
        } catch (Exception e) {
            throw new RuntimeException("Error in controller to call get() method");
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(userService.getAll());
        } catch (Exception e) {
            throw new RuntimeException("Error in controller to call getAll() method");
        }
    }
}
