package com.example.chatbot.repository;

import com.example.chatbot.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    // Search documents by title
    List<Document> findByTitleContainingIgnoreCase(String title);

    // Search documents by content
    List<Document> findByContentContainingIgnoreCase(String keyword);
}
