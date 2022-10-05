package com.phonedirectory.app.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonedirectory.app.model.Contact;
import com.phonedirectory.app.repository.ContactRepository;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;
//Mutable arraylist
    private List<Contact> contacts = new ArrayList<Contact>(Arrays.asList(
        new Contact("1", "91","9842307770", "8072600679", 1),
        new Contact("2", "91","9842307770", "8072600679", 1) 
    ));
    
    
    public List<Contact> getAllContacts(){
        List<Contact> contacts = new ArrayList<Contact>();
        contactRepository.findAll().forEach(contacts:: add);
        
        return contacts;
    }

    public Contact getContact(String contactId){
        return contacts.stream().filter(t -> t.getContactId().equals(contactId)).findFirst().get();
    }

    public void addContact(Contact contact){
            contactRepository.save(contact);
            //contacts.add(contact);
    }

    public void updateContact(Contact contact ,String contactId){
        for(int index = 0;index<contacts.size();index++){
            Contact c = contacts.get(index);
            if(c.getContactId().equals(contactId)){
                contacts.set(index, contact);
                return;
            }
        }
    }

    public void deleteContact(String contactId){
        contacts.removeIf(t -> t.getContactId().equals(contactId));
    }
}
