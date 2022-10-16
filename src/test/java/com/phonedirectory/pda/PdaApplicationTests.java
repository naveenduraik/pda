package com.phonedirectory.pda;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phonedirectory.app.PdaApplication;
import com.phonedirectory.app.Controller.JWTAuthenticationController;
import com.phonedirectory.app.model.Department;
import com.phonedirectory.app.model.UserDTO;
import com.phonedirectory.app.model.UserDetails;
import com.phonedirectory.app.repository.DepartmentRepository;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class) 

class PdaApplicationTests {	
	private  MockMvc mockMvc ;
	@Autowired
	private WebApplicationContext context;
	
	

	@Test
	void contextLoads() {
	}
	/* @BeforeEach
	public void setUp(WebApplicationContext context){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

	} */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);

    	this.mockMvc = MockMvcBuilders
            .standaloneSetup(new JWTAuthenticationController()).build();
		}
	
	 @Test
	public void TestCase1() throws Exception {		 
		 		//Sign Up
		 	 	String userdata = "{\"first_name\":\"naveen\",\"last_name\":\"durai\",\"primary_email_d\":\"naveendurai@iamneo.ai\",\"secondary_email_d\":\"naveendurai.k@gmail.com\" ,\"pass_Key\":\"test@123\",\"confirm_passkey\":\"test@123\",\"departmentId\":\"D2\",\"designation\":\"SDE\",\"username\":\"naveendurai\",\"password\":\"test@123\"}";

			 	mockMvc.perform(MockMvcRequestBuilders.post("/register")
		 	 			.contentType(MediaType.APPLICATION_JSON)
		 	 			.content(userdata)
		 	 			.accept(MediaType.APPLICATION_JSON))
		 	        	.andExpect(status().isOk())
		 	        	.andExpect(jsonPath("$").value("true"))
		 	        	.andReturn();
	}
	  @Test
	public void TestCase2() throws Exception {			
	//login
		String dataOne = "{\"username\":\"naveen\",\"password\":\"test@123\"}";
		mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
		        .contentType(MediaType.APPLICATION_JSON)
				.content(dataOne)
				.accept(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION, "Bearer token"))		
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").value("true"))
				.andReturn(); 
	}  
  

	
}
