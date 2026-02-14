package com.example.chatbot.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.core.ParameterizedTypeReference;
import java.util.Map;

@Service
public class ChatService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String pythonRagUrl = "http://localhost:8000/chat"; // your Python RAG microservice

    public String processMessage(String userMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = Map.of("message", userMessage);
        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        // ✅ Use exchange with ParameterizedTypeReference
        ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
                pythonRagUrl,
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<Map<String, Object>>() {}
        );

        // Extract the reply from the response JSON
        return (String) response.getBody().get("reply");
    }
}
