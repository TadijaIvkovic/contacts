package com.tadza.contacts;

import com.tadza.contacts.entities.Contact;
import com.tadza.contacts.services.ContactService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ContactsApplication {

    public static void main(String[] args) {
        ApplicationContext context=SpringApplication.run(ContactsApplication.class, args);
        var service=context.getBean(ContactService.class);

//        Contact contact=Contact.builder().email("tadija.com").name("tadija").phone("0603366192").build();
//        service.addContact(contact);
//
//        List<Contact> contacts=service.findContactsContaining("");
//        contacts.forEach(System.out::println);
//
//        service.removeContact(contact);
//
//        List<Contact> contacts2=service.findContactsContaining("");
//        contacts2.forEach(System.out::println);
    }

}
