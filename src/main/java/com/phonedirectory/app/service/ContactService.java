package com.phonedirectory.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonedirectory.app.model.Contact;
import com.phonedirectory.app.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;
//Mutable arraylist
      
    public List<Contact> getAllContacts(){
        List<Contact> contactList = new ArrayList<Contact>();
        contactRepository.findAll().forEach(contactList:: add);
        
        return contactList;
    }

    public Optional<Contact> getContact(int contactId){
       return contactRepository.findById(contactId);
    }

    public void addContact(Contact contact){
            contactRepository.save(contact);
    }

    public void updateContact(Contact contact ,int contactId){
            contactRepository.save(contact);
    }

    public void deleteContact(int contactId){
          contactRepository.deleteById(contactId);
    }

	
    public String userDetailsPhone(int userId) {
		return  contactRepository.userDetailsPhone(userId);
		
	}
    
    public String usernameDetailsPhone(String username) {
		return  contactRepository.usernameDetailsPhone(username);
		
	}
   
}
