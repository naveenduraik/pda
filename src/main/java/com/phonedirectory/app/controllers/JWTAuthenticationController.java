package com.phonedirectory.app.controllers;


import org.apache.logging.log4j.Logger;
import java.nio.charset.MalformedInputException;

import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
	// Create a new authentication token.
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JWTRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JWTResponse(token));
	}
	
	
	/** 
	 * @param user
	 * @return ResponseEntity<?>
	 */
	// Authenticates and saves a user.
	@PostMapping("/register")
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) {
		
		try{
			return ResponseEntity.ok(userDetailsService.save(user));

		}
		catch(NullPointerException ne){
			//System.err.println(ne);
			logger.getClass();
		}
		return null;
	}

	
	/** 
	 * @param username
	 * @param password
	 */
	// Authenticate using the given username and password.
	private void authenticate(String username, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			//System.err.println("UserDisabled"+e);
			logger.getClass();
		} catch (BadCredentialsException  e) {
			//System.err.println("Invalid Credentials"+e);
			logger.getClass();
		}
	}
	
}
