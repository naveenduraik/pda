package com.phonedirectory.app.controllers;


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

import com.phonedirectory.app.model.UserDetails;
import com.phonedirectory.app.service.UserDetailsService;

@RestController
public class UserDetailsController {
    @Autowired
        private UserDetailsService userdetailsService;

        @GetMapping("/users")
        public List<UserDetails> getAllUserDetails(){
            return userdetailsService.getAllUserDetails();
        }
        
        @GetMapping("/users/{userId}")
        public Optional<UserDetails> getUser(@PathVariable int userId){
            return userdetailsService .getUser(userId);
        }
        
        @PostMapping("/users")
        public void addContact(@RequestBody UserDetails userDetails){
                 userdetailsService.addUser(userDetails);
        }
    
        @PatchMapping("/users/{userId}")
        public void updateUser(@RequestBody UserDetails userDetails, @PathVariable int userId){
            userdetailsService.updateUserDetails(userDetails,userId );
        }
    
        @DeleteMapping("/users/{userId}")
        public void deleteUserDetails(@PathVariable int userId){
            userdetailsService.deleteUserDetails(userId);
        }
        
        


}
