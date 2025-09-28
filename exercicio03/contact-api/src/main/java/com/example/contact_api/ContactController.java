package com.example.contact_api;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contacts")  
public class ContactController {
    
    private List<Contact> contacts = new ArrayList<>();
    private Long nextId = 1L;
    
    public ContactController() {
        contacts.add(new Contact(nextId++, "João Silva", "9999-9999", "joao@email.com"));
        contacts.add(new Contact(nextId++, "Maria Santos", "8888-8888", "maria@email.com"));
        contacts.add(new Contact(nextId++, "Pedro Oliveira", "7777-7777", "pedro@email.com"));
    }
    
    @GetMapping
    public List<Contact> getAllContacts() {
        return contacts;
    }
    
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contacts.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst()
                .orElse(null);  // Retorna null se não encontrar
    }
    
    @GetMapping("/search")
    public List<Contact> searchContactsByName(@RequestParam String name) {
        System.out.println("🔍 Buscando contatos com nome: " + name);
        
        List<Contact> result = contacts.stream()
                .filter(contact -> contact.getNome().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
        
        System.out.println("✅ Encontrados " + result.size() + " contatos");
        return result;
    }
    
    @PostMapping
    public Contact createContact(@RequestBody Contact newContact) {
        newContact.setId(nextId++);
        contacts.add(newContact);
        System.out.println("✅ Contato criado: " + newContact.getNome());
        return newContact;
    }
    
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId().equals(id)) {
                updatedContact.setId(id);
                contacts.set(i, updatedContact);
                System.out.println("✅ Contato atualizado: " + updatedContact.getNome());
                return updatedContact;
            }
        }
        return null; 
    }
    
     @DeleteMapping("/{id}")
    public String deleteContact(@PathVariable Long id) {
        boolean removed = contacts.removeIf(contact -> contact.getId().equals(id));
        if (removed) {
            System.out.println("✅ Contato removido ID: " + id);
            return "Contato removido com sucesso";
        } else {
            return "Contato não encontrado";
        }
    }
}