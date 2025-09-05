package com.example.security.controller;

import com.example.security.entity.User;
import com.example.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class Controller {

    private final UserService userService;

    @PostMapping("/save")
    public User save(@RequestBody final User user) {
        return userService.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody final Map<String, String> request) {
        return userService.login(request);
    }

    @GetMapping("/{id}")
    public User get(@PathVariable final String id) {
        return userService.find(id);
    }
}
