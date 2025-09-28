package com.example.exercicio02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercicio02Application {
    public static void main(String[] args) {
        System.out.println("🚀 INICIANDO APLICAÇÃO SPRING BOOT...");
        SpringApplication.run(Exercicio02Application.class, args);
        System.out.println("✅ API RODANDO: http://localhost:8080");
    }
}