package org.example.secure8test.service;

import com.java.token.JwtTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.example.secure8test.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final JwtTokenGenerator jwtTokenGenerator;
    private final List<User> users = new ArrayList<>();

    public User save(final User user) {
        users.add(user);
        return user;
    }

    public String login(final String email, final String password) {
        final User user = users.getFirst();
        if (!user.getEmail().equals(email) && !user.getPassword().equals(password)) {
            return "nao deu para logar";
        }
        return jwtTokenGenerator.generateToken(user.getEmail());
    }

    public List<User> get() {
        return users;
    }
}
