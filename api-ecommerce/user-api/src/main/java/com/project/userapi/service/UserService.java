package com.project.userapi.service;

import com.project.userapi.dto.request.LoginRequest;
import com.project.userapi.dto.request.RegisterRequest;
import com.project.userapi.dto.response.LoginResponse;
import com.project.userapi.entity.User;
import com.project.userapi.exception.ErrorToRegisterUserException;
import com.project.userapi.mapper.UserMapper;
import com.project.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtEncoder jwtEncoder;

    public void save(final RegisterRequest request) {
        try {
            final User user = UserMapper.map(request);
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(user);
            log.info("User registered");
        } catch (Exception e) {
            throw new ErrorToRegisterUserException();
        }
    }

    public User get(final String username) {
        return userRepository.findUserByUsername(username)
                .orElseGet(() -> null);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public LoginResponse login(final LoginRequest request) {
        final UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                );

        final Authentication authentication = authenticationManager
                .authenticate(authToken);

        final Instant now = Instant.now();
        final Instant expiry = now.plus(1, ChronoUnit.HOURS);

        final JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(expiry)
                .subject(authentication.getName())
                .claim("authorities", authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .build();

        final JwtEncoderParameters parameters = JwtEncoderParameters.from(claims);
        final Jwt jwt = jwtEncoder.encode(parameters);

        return new LoginResponse(jwt.getTokenValue());
    }
}
