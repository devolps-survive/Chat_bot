package com.example.chatbot.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255) // specify length and non-null
    private String name;

    @Column(name = "path", nullable = false, length = 500) // specify length and non-null
    private String path;

    @Column(name = "uploaded_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime uploadedAt;

    // Optional constructor without ID
    public Document(String name, String path, LocalDateTime uploadedAt) {
        this.name = name;
        this.path = path;
        this.uploadedAt = uploadedAt;
    }
}
