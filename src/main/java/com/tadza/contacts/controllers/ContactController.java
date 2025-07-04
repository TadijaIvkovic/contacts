package com.tadza.contacts.controllers;


import com.tadza.contacts.entities.Contact;
import com.tadza.contacts.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactRepository repo;

    @GetMapping
    public List<Contact> getAll() {
        return repo.findAll();
    }



    @PostMapping
    public Contact create(@RequestBody Contact contact) {
        return repo.save(contact);
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable Long id, @RequestBody Contact c) {
        Contact existing = repo.findById(id).orElseThrow();
        existing.setName(c.getName());
        existing.setEmail(c.getEmail());
        existing.setPhone(c.getPhone());
        return repo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}