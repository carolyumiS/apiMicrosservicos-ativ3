package com.example.contact_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação que marca esta classe como aplicação Spring Boot
@SpringBootApplication
public class ContactApiApplication {
    public static void main(String[] args) {
        // Inicia a aplicação
        SpringApplication.run(ContactApiApplication.class, args);
        System.out.println("✅ API de Contatos rodando em: http://localhost:8080");
    }
}