package com.phonedirectory.app.repository;
import org.springframework.data.repository.CrudRepository;

import com.phonedirectory.app.model.Contact;

public interface ContactRepository extends CrudRepository<Contact,Integer>  {
    
}
