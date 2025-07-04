package com.tadza.contacts.services;

import com.tadza.contacts.entities.Contact;
import com.tadza.contacts.repositories.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public void addContact(Contact contact) {
        System.out.println("Adding contact " + contact);
        contactRepository.save(contact);

    }

    public void removeContact(Contact contact) {
        System.out.println("Removing contact " + contact);
        contactRepository.delete(contact);
    }

    public void searchContact(String name, String number){
        if(name!=null && number!=null){
            System.out.println("Searching for contact with number: " + number + " and name: " + name);
        }
        else if(name!=null){
            System.out.println("Searching for contact " + name);
        }
        else if(number!=null){
            System.out.println("Searching for contact with number: " + number);
        }
        else{
            System.out.println("Please enter name or number");
        }
    }

    public List<Contact> findContactsContaining(String digits){
        List<Contact> results = contactRepository.findByPhoneContaining(digits);
        return results;
    }




}
