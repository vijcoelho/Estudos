package com.java.apidevsagi.controller;

import com.java.apidevsagi.dto.request.SaveUserRequest;
import com.java.apidevsagi.entity.User;
import com.java.apidevsagi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getHello() {
        return "Fala seus bando de devs!";
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid final SaveUserRequest request) {
        return ResponseEntity.ok(userService.save(request));
    }
}
