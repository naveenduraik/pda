package com.phonedirectory.app.Controller;


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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phonedirectory.app.config.JWTTokenUtil;
import com.phonedirectory.app.model.JWTRequest;
import com.phonedirectory.app.model.JWTResponse;
import com.phonedirectory.app.model.UserDTO;
import com.phonedirectory.app.service.JWTUserDetailsService;


@RestController
@CrossOrigin(origins = "?", allowedHeaders = "?")

public class JWTAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	private JWTUserDetailsService userDetailsService;

	@PostMapping("/authenticate")
	//@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JWTRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JWTResponse(token));
	}
	
	@PostMapping("/register")
	//@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) {
		
		try{
			return ResponseEntity.ok(userDetailsService.save(user));

		}
		catch(NullPointerException ne){
			System.out.println(ne);
		}
		return null;
	}

	private void authenticate(String username, String password) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			//throw new Exception("USER_DISABLED", e);
			System.out.println("UserDisabled"+e);
		} catch (BadCredentialsException  e) {
			//throw new Exception("INVALID_CREDENTIALS", e);
			System.out.println("Invalid Credentials"+e);
		}
	}
	
}
