package com.tadza.contacts.repositories;

import com.tadza.contacts.entities.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Long> {


    @Query("SELECT c FROM Contact c WHERE c.phone LIKE %:digits%")
    List<Contact> findByPhoneContaining(@Param("digits") String digits);


}