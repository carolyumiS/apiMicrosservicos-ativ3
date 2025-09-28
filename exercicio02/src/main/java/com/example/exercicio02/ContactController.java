package com.example.exercicio02;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    
    private List<Contact> contacts = new ArrayList<>();
    
    public ContactController() {
        System.out.println("🎯 CONTACT CONTROLLER INICIALIZADO!");
        contacts.add(new Contact(1L, "João Silva", "9999-9999", "joao@email.com"));
        contacts.add(new Contact(2L, "Maria Santos", "8888-8888", "maria@email.com"));
        contacts.add(new Contact(3L, "Pedro Oliveira", "7777-7777", "pedro@email.com"));
        System.out.println("✅ " + contacts.size() + " contatos carregados");
    }
    
    // EXERCÍCIO 1
    @GetMapping("/search")
    public List<Contact> searchContactsByName(@RequestParam String name) {
        System.out.println("🔍 Buscando contatos com nome: " + name);
        List<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getNome().toLowerCase().contains(name.toLowerCase())) {
                result.add(contact);
            }
        }
        return result;
    }
    
    @GetMapping
    public List<Contact> getAllContacts() {
        return contacts;
    }
}