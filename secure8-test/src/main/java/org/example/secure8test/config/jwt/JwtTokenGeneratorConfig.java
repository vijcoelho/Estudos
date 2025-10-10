package org.example.secure8test.config.jwt;

import com.java.config.JwtConfig;
import com.java.token.JwtTokenGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class JwtTokenGeneratorConfig {

    @Bean
    public JwtTokenGenerator jwtTokenGenerator(final JwtConfig jwtConfig) {
        return JwtTokenGenerator.builder()
                .claims(new HashMap<>())
                .jwtConfig(jwtConfig)
                .build();
    }
}
