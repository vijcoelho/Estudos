package org.example.secure8test.controller;

import lombok.RequiredArgsConstructor;
import org.example.secure8test.entity.User;
import org.example.secure8test.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody final User user) {
        final User response = userService.save(user);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam("email") final String email,
            @RequestParam("password") final String password
    ) {
        final String response = userService.login(email, password);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> get() {
        final List<User> users = userService.get();
        return ResponseEntity.ok(users);
    }
}
