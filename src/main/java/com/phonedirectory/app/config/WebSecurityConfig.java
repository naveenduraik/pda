package com.phonedirectory.app.config;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.phonedirectory.app.service.JWTUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	Logger logger;
	@Autowired
	private JWTUserDetailsService jwtUserDetailsService;

	@Autowired
	private JWTRequestFilter jwtRequestFilter;

	@Autowired
	private JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint;


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		try {
			auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
		} catch (Exception e) {
			logger.log(null, e);
		}
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean()  {
		try {
			return super.authenticationManagerBean();
		} catch (Exception e) {
			logger.log(null, e);
		}
		return null;
	}

	
	@Override
	protected void configure(HttpSecurity httpSecurity)  {
		// dont authenticate this particular request 
		try {
		
			httpSecurity.csrf().disable().authorizeRequests().antMatchers("/authenticate", "/register").permitAll().
					// all other requests need to be authenticated
					anyRequest().authenticated().and().
					// make sure we use stateless session; session won't be used to
					// store user's state.
					exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		} catch (Exception e) {
			logger.log(null,e);
		}
		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}

	
	
}
