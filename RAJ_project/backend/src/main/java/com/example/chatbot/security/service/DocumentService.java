package com.example.chatbot.service;

import com.example.chatbot.model.Document;
import com.example.chatbot.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document saveFile(MultipartFile file) {
        try {
            String uploadDir = System.getProperty("user.dir") + "/uploads/";
            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String filePath = uploadDir + file.getOriginalFilename();
            file.transferTo(new File(filePath));

            Document doc = new Document(file.getOriginalFilename(), filePath, LocalDateTime.now());
            return documentRepository.save(doc);

        } catch (IOException e) {
            throw new RuntimeException("Could not store file: " + e.getMessage());
        }
    }
}
