package com.phonedirectory.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.phonedirectory.app.model.UserDTO;
import com.phonedirectory.app.repository.UserDetailsRepository;

@Service
public class JWTUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDetailsRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.phonedirectory.app.model.UserDetails user = userDao.findByUsername(username);
		if (user == null) {			
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public com.phonedirectory.app.model.UserDetails save(UserDTO user) {
		com.phonedirectory.app.model.UserDetails newUser = new com.phonedirectory.app.model.UserDetails();
		newUser.setConfirmPasskey(user.getConfirmPasskey());
		newUser.setDepartmentId(user.getDepartmentId());
		newUser.setDesignation(user.getDesignation());
		newUser.setPrimaryEmailId(user.getPrimaryEmailId());
		newUser.setSecondaryEmailId(user.getSecondaryEmailId());
		newUser.setPassKey(user.getPassKey());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}
}