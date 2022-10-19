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

import com.phonedirectory.app.PdaApplication;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes = PdaApplication.class)
@AutoConfigureMockMvc
class PdaApplicationTests {	
	
	@Autowired
	private  MockMvc mockMvc ;


	@Test
	public void userRegister() throws Exception {		 
		 		//Sign Up
		 	 	String userdata = "{\"userId\":\"1\",\"firstName\":\"naveen\",\"lastName\":\"durai\",\"primaryEmailId\":\"naveendurai@iamneo.ai\",\"secondaryEmailId\":\"naveendurai.k@gmail.com\" ,\"passKey\":\"test@123\",\"confirmPasskey\":\"test@123\",\"departmentId\":\"D2\",\"designation\":\"SDE\",\"username\":\"naveendurai\",\"password\":\"test@123\"}";

			 	mockMvc.perform(MockMvcRequestBuilders.post("/register")
		 	 			.contentType(MediaType.APPLICATION_JSON)
		 	 			.content(userdata)
		 	 			.accept(MediaType.APPLICATION_JSON))
		 	        	.andExpect(status().isOk())
		 	        	//.andExpect(jsonPath("$").value("true"))
		 	        	.andReturn();
	}
	/*   @Test
	public void TestCase2() throws Exception {			
	//login
		String dataOne = "{\"username\":\"naveen\",\"password\":\"test@123\"}";	
			MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
		        .contentType(MediaType.APPLICATION_JSON)
				.content(dataOne)
				.accept(MediaType.APPLICATION_JSON))
				//.header(HttpHeaders.AUTHORIZATION, "Bearer token"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").value("true"))
				.andReturn();  		

				String response = result.getResponse().getContentAsString();
				response = response.replace("{\"access_token\": \"", "");
				String token = response.replace("\"}", "");

				mockMvc.perform(MockMvcRequestBuilders.get("/authenticate")
				.header("Authorization", "Bearer " + token))
				.andExpect(status().isOk());
	}    */

	@Test
	public void contactEntry() throws Exception{
		String data = "{\"countryCode\":\"91\",\"primaryMobileNumber\":\"91\",\"secondaryMobileNumber\":\"91\",\"userId\":\"2\"}";	
		mockMvc.perform(MockMvcRequestBuilders.post("/contacts")
		 	 			.contentType(MediaType.APPLICATION_JSON)
		 	 			.content(data)
		 	 			.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
		 	        	//.andExpect(jsonPath("$").value("true"))
		 	        	.andReturn();
	}

	
	@Test
	public void departmentEntry() throws Exception{
		String data = "{\"departmentId\":\"d02\",\"departmentName\":\"Stark1\",\"details\":\"development\"}";	
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
		 	 			.contentType(MediaType.APPLICATION_JSON)
		 	 			.content(data)
		 	 			.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
		 	        	//.andExpect(jsonPath("$").value("true"))
		 	        	.andReturn();
	}

	/* @Test
	 public void addressEntry() throws Exception{

	 } */

	
  

	
}
