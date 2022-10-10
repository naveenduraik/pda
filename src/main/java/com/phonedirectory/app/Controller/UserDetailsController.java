package com.phonedirectory.app.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phonedirectory.app.model.UserDetails;
import com.phonedirectory.app.service.UserDetailsService;

@RestController
public class UserDetailsController {
    @Autowired
        private UserDetailsService userdetailsService;

        @RequestMapping(method = RequestMethod.GET,value ="/users")
        public List<UserDetails> getAllUserDetails(){
            return userdetailsService.getAllUserDetails();
        }
        
        @RequestMapping(method = RequestMethod.GET,value ="/users/{userId}")
        public Optional<UserDetails> getUser(@PathVariable int userId){
            return userdetailsService .getUser(userId);
        }
    
        @RequestMapping(method = RequestMethod.POST,value = "/users")
        public void addContact(@RequestBody UserDetails userDetails){
                 userdetailsService.addUser(userDetails);
        }
    
        @RequestMapping(method = RequestMethod.PATCH,value="/users/{userId}")
        public void updateUser(@RequestBody UserDetails userDetails, @PathVariable int userId){
            userdetailsService.updateUserDetails(userDetails,userId );
        }
    
        @RequestMapping(method = RequestMethod.DELETE,value ="/users/{userId}")
        public void deleteUserDetails(@PathVariable int userId){
            userdetailsService.deleteUserDetails(userId);
        }
        
        


}
