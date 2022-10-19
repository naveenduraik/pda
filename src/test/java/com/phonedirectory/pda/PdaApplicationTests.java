package com.phonedirectory.pda;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.phonedirectory.app.PdaApplication;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



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


	/* private int addressId;
	private String t_doorNo;
	private String t_streetName;
	private String t_city;
	private String t_pinCode;
	private String t_state;
	private String t_country;
	private String p_doorNo;
	private String p_streetName;
	private String p_city;
	private String p_pinCode;
	private String p_state;
	private String p_country;
    private int userId; */
	 @Test
	 public void addressEntry() throws Exception{

		String data = "{\"t_doorNo\":\"d02\",\"t_streetName\":\"Stark1\",\"t_city\":\"development\",\"t_pinCode\":\"development\",\"t_state\":\"development\",\"t_country\":\"development\",\"p_doorNo;\":\"development\",\"p_streetName;\":\"development\",\"p_city\":\"development\",\"p_pinCode\":\"development\",\"p_state\":\"development\",\"p_country\":\"development\",\"user_id\":\"1\" }";

		mockMvc.perform(MockMvcRequestBuilders.post("/address")
		 	 			.contentType(MediaType.APPLICATION_JSON)
		 	 			.content(data)
		 	 			.accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
		 	        	//.andExpect(jsonPath("$").value("true"))
		 	        	.andReturn();

	 } 

	
  

	
}
