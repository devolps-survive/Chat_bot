package com.example.chatbot.repository;

import com.example.chatbot.model.ChatMessage;
import com.example.chatbot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

    // Get all messages of a specific user
    List<ChatMessage> findByUser(User user);

    // Get messages ordered by newest first
    List<ChatMessage> findByUserOrderByCreatedAtDesc(User user);
}

