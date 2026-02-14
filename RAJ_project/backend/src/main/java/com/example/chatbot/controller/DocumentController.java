package com.example.chatbot.controller;

import com.example.chatbot.service.DocumentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    // ✅ THIS CONSTRUCTOR IS REQUIRED
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        documentService.saveFile(file);
        return "File uploaded successfully";
    }
}
