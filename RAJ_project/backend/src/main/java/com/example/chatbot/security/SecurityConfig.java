package com.example.chatbot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for POST
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/chat").permitAll()   // allow POST /chat without auth
                .requestMatchers("/chat/**").permitAll() // in case of trailing slash
                .anyRequest().authenticated()           // everything else requires JWT
            )
            .httpBasic(httpBasic -> httpBasic.disable()); // disable default login prompt

        return http.build();
    }
}
