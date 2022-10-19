package com.phonedirectory.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phonedirectory.app.model.Contact;
import com.phonedirectory.app.service.ContactService;
@RestController
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }
    
    @GetMapping("/contacts/{contactId}")
    public Optional<Contact> getContact(@PathVariable int contactId){
        return contactService .getContact(contactId);
    }

    @PostMapping("/contacts")
    public void addContact(@RequestBody Contact contact){
             contactService.addContact(contact);
    }

    //put or patch can be used to update the record -- but patch is best suited to update a particular field
    //in a selected record -- if we are updating the whole record then put can be used 
    //patch responds back at a lesser time line (similar to replacing a bail in cricket kit rather than replacing the whole kit bag)

    @PatchMapping("/contacts/{contactId}")
    public void updateContact(@RequestBody Contact contact, @PathVariable int contactId){
        contactService.updateContact(contact,contactId );
    }

    @DeleteMapping("/contacts/{contactId}")
    public void deleteContact(@PathVariable int contactId){
        contactService.deleteContact(contactId);
    }
    
    @GetMapping("/contacts/phoneNo/{userId}")
    public String userDetailsPhone(@PathVariable int userId){
        return contactService.userDetailsPhone(userId);
    }
    
    @GetMapping("/contacts/usernamephoneNo/{username}")
    public String usernameDetailsPhone(@PathVariable String username){
        return contactService.usernameDetailsPhone(username);
    }

    
    
    
    
}
