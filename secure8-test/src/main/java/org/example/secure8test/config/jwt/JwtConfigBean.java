package org.example.secure8test.config.jwt;

import com.java.config.JwtConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfigBean {

    @Bean
    public JwtConfig jwtConfig() {
        return JwtConfig.builder()
                .expirationMillis(30000)
                .issuer("issuer")
                .secretKey("3cab7324dfb23c5cbd57b97dde33c2d6a69eb2eb9149cbd18f144aef02d06126")
                .build();
    }
}
