package com.example.chatbot.service;

import com.example.chatbot.model.User;
import com.example.chatbot.repository.UserRepository;
import com.example.chatbot.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       JwtUtil jwtUtil,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return jwtUtil.generateToken(user.getEmail());
    }

    public String login(String email, String password) {
        // Use Optional for null safety
        Optional<User> userOpt = userRepository.findByEmail(email);
        User user = userOpt.orElseThrow(() -> 
                new UsernameNotFoundException("User not found with email: " + email));

        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user.getEmail());
        }

        throw new RuntimeException("Invalid password");
    }
}
