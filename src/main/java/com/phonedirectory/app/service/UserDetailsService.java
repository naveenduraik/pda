package com.phonedirectory.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonedirectory.app.model.UserDetails;
import com.phonedirectory.app.repository.UserDetailsRepository;

@Service
public class UserDetailsService {
    
    @Autowired
    private UserDetailsRepository userDetailsRepository;
    public List<UserDetails> getAllUserDetails(){
        List<UserDetails> users= new ArrayList<UserDetails>();
        userDetailsRepository.findAll().forEach(users:: add);        
        return users;
    }

    public Optional<UserDetails> getUser(int userId){
       return userDetailsRepository.findById(userId);
    }

    public void addUser(UserDetails userdetails){
            userDetailsRepository.save(userdetails);
    }

    public void updateUserDetails(UserDetails userDetails ,int userId){ 
        userDetailsRepository.save(userDetails);
    }

    public void deleteUserDetails(int userId){
          userDetailsRepository.deleteById(userId);
    }
    
    
}
