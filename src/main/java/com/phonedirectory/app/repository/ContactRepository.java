package com.phonedirectory.app.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.phonedirectory.app.model.Contact;

public interface ContactRepository extends CrudRepository<Contact,Integer>  {
    
    public List<Contact> findContactByUserId(int userId);
}
