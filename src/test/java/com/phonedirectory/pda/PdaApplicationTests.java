package com.phonedirectory.pda;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.phonedirectory.app.PdaApplication;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;




@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = PdaApplication.class)
@AutoConfigureMockMvc
class PdaApplicationTests {	
	
	@Autowired
	private  MockMvc mockMvc ;

	// Register a new user.
	@Test
	void userRegister() throws Exception {		 
		 		//Sign Up
		 	 	String userdata = "{\"userId\":\"1\",\"firstName\":\"naveen\",\"lastName\":\"durai\",\"primaryEmailId\":\"naveendurai@iamneo.ai\",\"secondaryEmailId\":\"naveendurai.k@gmail.com\" ,\"passKey\":\"test@123\",\"confirmPasskey\":\"test@123\",\"departmentId\":\"D2\",\"designation\":\"SDE\",\"username\":\"durai121\",\"password\":\"test@123\"}";

			 	mockMvc.perform(MockMvcRequestBuilders.post("/register")
		 	 			.contentType(MediaType.APPLICATION_JSON)
		 	 			.content(userdata)
		 	 			.accept(MediaType.APPLICATION_JSON))
		 	        	.andExpect(status().isOk())
		 	        	//.andExpect(jsonPath("$").value("true"))
		 	        	.andReturn();
							// Authenticate a user.
	}
	// Authenticate a user.
	   @Test
	void authenticationCheck() throws Exception {			
	//login
		String dataOne = "{\"username\":\"durai121\",\"password\":\"test@123\"}";	
			   mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
		        .contentType(MediaType.APPLICATION_JSON)
				.content(dataOne)
				.accept(MediaType.APPLICATION_JSON))
				//.header(HttpHeaders.AUTHORIZATION))
				.andExpect(status().isOk())
				//.andExpect(jsonPath("$").value("true"))
				.andReturn();  		
	}    

	// Set a contact.
	@Test
	void setContact() throws Exception{
		String data = "{\"countryCode\":\"91\",\"primaryMobileNumber\":\"91\",\"secondaryMobileNumber\":\"91\",\"userId\":\"2\"}";	
		mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
		 	 			.contentType(MediaType.APPLICATION_JSON)
		 	 			.content(data)
		 	 			.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
		 	        	//.andExpect(jsonPath("$").value("true"))
		 	        	.andReturn();						
	}

	// Get a single contact.
	@Test
	void getContact() throws Exception{
		//String data = "{\"countryCode\":\"91\",\"primaryMobileNumber\":\"91\",\"secondaryMobileNumber\":\"91\",\"userId\":\"2\"}";	
		 mockMvc.perform(MockMvcRequestBuilders.get("/contacts")
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andDo(print())
						//.andExpect(MockMvcResultMatchers.jsonPath("$[*].primaryMobileNumber").value("91"))
						.andReturn();

			
	}					
	
	// Get the phone number of a user.
	@Test
	void getUserPhoneNumber() throws Exception{
			//String data = "{\"countryCode\":\"91\",\"primaryMobileNumber\":\"91\",\"secondaryMobileNumber\":\"91\",\"userId\":\"2\"}";	
			 mockMvc.perform(MockMvcRequestBuilders.get("/contacts/phoneNo/{userId}","10000")
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(print())
					//.andExpect(MockMvcResultMatchers.jsonPath("$[*].primaryMobileNumber").value("91"))
					.andReturn();
			
						
	}					
				
	
	// Create a new department.
	@Test
	void departmentEntry() throws Exception{
		String data = "{\"departmentId\":\"d02\",\"departmentName\":\"Stark1\",\"details\":\"development\"}";	
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
		 	 			.contentType(MediaType.APPLICATION_JSON)
		 	 			.content(data)
		 	 			.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
		 	        	//.andExpect(jsonPath("$").value("true"))
		 	        	.andReturn();
	}

	// Sets the address of the test.
	 @Test
	 void setAddress() throws Exception{

		String data = "{\"tDoorNo\":\"d02\",\"tStreetName\":\"Stark1\",\"tCity\":\"development\",\"tPinCode\":\"development\",\"tState\":\"development\",\"tCountry\":\"development\",\"pDoorNo;\":\"development\",\"pStreetName;\":\"development\",\"pCity\":\"development\",\"pPinCode\":\"development\",\"pState\":\"development\",\"pCountry\":\"development\",\"userId\":\"1\" }";

		mockMvc.perform(MockMvcRequestBuilders.post("/address")
		 	 			.contentType(MediaType.APPLICATION_JSON)
		 	 			.content(data)
		 	 			.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
		 	        	//.andExpect(jsonPath("$").value("true"))
		 	        	.andReturn();
} 

	 @Test
	 void getAddress() throws Exception{	
		mockMvc.perform(MockMvcRequestBuilders.get("/address")
						.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andDo(print())
						.andExpect(MockMvcResultMatchers.jsonPath("$[*].tDoorNo").exists())
						.andReturn();

	 } 
	
}
