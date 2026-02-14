package com.example.chatbot.controller;

import com.example.chatbot.service.ChatService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;  

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public Map<String, String> sendMessage(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        String reply = chatService.processMessage(message);
        return Map.of("reply", reply);
    }
}
