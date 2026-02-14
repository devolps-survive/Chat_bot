package com.example.chatbot.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() {
        return email;
    }
    public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
}
