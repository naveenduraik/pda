package com.phonedirectory.app.controllers;


import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phonedirectory.app.config.JWTTokenUtil;
import com.phonedirectory.app.model.JWTRequest;
import com.phonedirectory.app.model.JWTResponse;
import com.phonedirectory.app.model.UserDTO;
import com.phonedirectory.app.service.JWTUserDetailsService;


@RestController
@CrossOrigin(origins = "http://localhost:8080/", allowedHeaders = "*")
// Authenticates the user with the given username and password.
public class JWTAuthenticationController {

	Logger logger;


	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	private JWTUserDetailsService userDetailsService;

	
	/** 
	 * @param authenticationRequest
	 * @return ResponseEntity<?>
	 * @throws Exception
	 */
	
	@PostMapping("/authenticate")
	public ResponseEntity<JWTResponse> createAuthenticationToken(@RequestBody JWTRequest authenticationRequest){

		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
			final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JWTResponse(token));
		} catch (Exception e) {
			logger.log(null, e);
		}
		return null;
		
	}
	
	
	/** 
	 * @param user
	 * @return ResponseEntity<?>
	 */
	@PostMapping("/register")
	public ResponseEntity<com.phonedirectory.app.model.UserDetails> saveUser(@RequestBody UserDTO user) {
		
		try{
			return ResponseEntity.ok(userDetailsService.save(user));

		}
		catch(NullPointerException ne){
		logger.info(ne);
	}
		return null;
	}

	
	/** 
	 * @param username
	 * @param password
	 */
	// Authenticate using the given username and password.
	private void authenticate(String username, String password) throws UsernameNotFoundException{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException | BadCredentialsException e) {
				logger.info(e);
			
		} 
	}
	
}
