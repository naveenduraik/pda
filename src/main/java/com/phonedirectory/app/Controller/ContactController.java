package com.phonedirectory.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phonedirectory.app.model.Contact;
import com.phonedirectory.app.model.UserDetails;
import com.phonedirectory.app.service.ContactService;
@RestController
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @RequestMapping(method = RequestMethod.GET,value ="/contacts")
    public List<Contact> getAllContacts(){
        return contactService.getAllContacts();
    }
    
    @RequestMapping(method = RequestMethod.GET,value ="/contacts/{contactId}")
    public Optional<Contact> getContact(@PathVariable int contactId){
        return contactService .getContact(contactId);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/contacts")
    public void addContact(@RequestBody Contact contact){
             contactService.addContact(contact);
    }

    //put or patch can be used to update the record -- but patch is best suited to update a particular field
    //in a selected record -- if we are updating the whole record then put can be used 
    //patch responds back at a lesser time line (similar to replacing a bail in cricket kit rather than replacing the whole kit bag)
    @RequestMapping(method = RequestMethod.PATCH,value="/contacts/{contactId}")
    public void updateContact(@RequestBody Contact contact, @PathVariable int contactId){
        contactService.updateContact(contact,contactId );
    }

    @RequestMapping(method = RequestMethod.DELETE,value ="/contacts/{contactId}")
    public void deleteContact(@PathVariable int contactId){
        contactService.deleteContact(contactId);
    }
    
    @RequestMapping(method = RequestMethod.GET,value ="/contacts/phoneNo/{userId}")
    public String userDetailsPhone(@PathVariable int userId){
        return contactService.userDetailsPhone(userId);
    }
    
    @RequestMapping(method = RequestMethod.GET,value ="/contacts/usernamephoneNo/{username}")
    public String usernameDetailsPhone(@PathVariable String username){
        return contactService.usernameDetailsPhone(username);
    }

    
    
    
    
}
