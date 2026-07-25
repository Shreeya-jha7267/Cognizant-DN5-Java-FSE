package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.springlearn.controller.CountryController;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringLearnApplicationTests {

	@Autowired
	private CountryController countryController;

	@Autowired
	private MockMvc mvc;

	// Basic Auth credentials base64 for "user:pwd"
	private static final String AUTH_HEADER = "Basic dXNlcjpwd2Q=";

	@Test
	public void contextLoads() {
		assertNotNull(countryController);
	}

	@Test
	public void testSayHello() throws Exception {
		ResultActions actions = mvc.perform(get("/hello").header("Authorization", AUTH_HEADER));
		actions.andExpect(status().isOk());
		actions.andExpect(content().string("Hello World!!"));
	}

	@Test
	public void testGetCountry() throws Exception {
		ResultActions actions = mvc.perform(get("/country").header("Authorization", AUTH_HEADER));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$.code").value("IN"));
		actions.andExpect(jsonPath("$.name").exists());
		actions.andExpect(jsonPath("$.name").value("India"));
	}

	@Test
	public void testGetCountryException() throws Exception {
		ResultActions actions = mvc.perform(get("/countries/az").header("Authorization", AUTH_HEADER));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("Country not found"));
	}

	@Test
	public void testAddCountrySuccess() throws Exception {
		String validCountryJson = "{\"code\":\"US\",\"name\":\"United States\"}";
		ResultActions actions = mvc.perform(post("/countries")
				.header("Authorization", AUTH_HEADER)
				.contentType(MediaType.APPLICATION_JSON)
				.content(validCountryJson));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.code").value("US"));
	}

	@Test
	public void testAddCountryValidationError() throws Exception {
		String invalidCountryJson = "{\"code\":\"U\",\"name\":\"United States\"}";
		ResultActions actions = mvc.perform(post("/countries")
				.header("Authorization", AUTH_HEADER)
				.contentType(MediaType.APPLICATION_JSON)
				.content(invalidCountryJson));
		actions.andExpect(status().isBadRequest());
		actions.andExpect(jsonPath("$.errors[0]").value("Country code should be 2 characters"));
	}

	@Test
	public void testGetAuthenticateAndAccessCountriesWithJwt() throws Exception {
		// 1. Get Token using Basic Auth
		MvcResult result = mvc.perform(get("/authenticate").header("Authorization", AUTH_HEADER))
				.andExpect(status().isOk())
				.andReturn();
		
		String responseString = result.getResponse().getContentAsString();
		// response looks like {"token":"eyJhbGc..."}
		String token = responseString.split("\"token\":\"")[1].split("\"")[0];
		assertNotNull(token);

		// 2. Call protected resource using Bearer Token
		ResultActions actions = mvc.perform(get("/countries")
				.header("Authorization", "Bearer " + token));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$[0].code").value("IN"));
	}

	@Test
	public void testUpdateEmployeeSuccess() throws Exception {
		String validEmployeeJson = "{\n" +
				"  \"id\": 1,\n" +
				"  \"name\": \"John Updated\",\n" +
				"  \"salary\": 60000.0,\n" +
				"  \"permanent\": true,\n" +
				"  \"dateOfBirth\": \"01/01/1990\",\n" +
				"  \"department\": {\n" +
				"    \"id\": 1,\n" +
				"    \"name\": \"IT\"\n" +
				"  },\n" +
				"  \"skills\": [\n" +
				"    {\n" +
				"      \"id\": 101,\n" +
				"      \"name\": \"Java\"\n" +
				"    }\n" +
				"  ]\n" +
				"}";
		mvc.perform(put("/employees")
				.header("Authorization", AUTH_HEADER)
				.contentType(MediaType.APPLICATION_JSON)
				.content(validEmployeeJson))
				.andExpect(status().isOk());
	}

	@Test
	public void testUpdateEmployeeNotFound() throws Exception {
		String invalidEmployeeJson = "{\n" +
				"  \"id\": 999,\n" +
				"  \"name\": \"Non Existent\",\n" +
				"  \"salary\": 60000.0,\n" +
				"  \"permanent\": true,\n" +
				"  \"dateOfBirth\": \"01/01/1990\",\n" +
				"  \"department\": {\n" +
				"    \"id\": 1,\n" +
				"    \"name\": \"IT\"\n" +
				"  },\n" +
				"  \"skills\": [\n" +
				"    {\n" +
				"      \"id\": 101,\n" +
				"      \"name\": \"Java\"\n" +
				"    }\n" +
				"  ]\n" +
				"}";
		mvc.perform(put("/employees")
				.header("Authorization", AUTH_HEADER)
				.contentType(MediaType.APPLICATION_JSON)
				.content(invalidEmployeeJson))
				.andExpect(status().isNotFound())
				.andExpect(status().reason("Employee not found"));
	}

	@Test
	public void testUpdateEmployeeHttpMessageNotReadable() throws Exception {
		// Incorrect format for numeric field id (string "abc" instead of number)
		String badFormatJson = "{\n" +
				"  \"id\": \"abc\",\n" +
				"  \"name\": \"Bad Format\",\n" +
				"  \"salary\": 60000.0,\n" +
				"  \"permanent\": true,\n" +
				"  \"dateOfBirth\": \"01/01/1990\"\n" +
				"}";
		mvc.perform(put("/employees")
				.header("Authorization", AUTH_HEADER)
				.contentType(MediaType.APPLICATION_JSON)
				.content(badFormatJson))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.message").value("Incorrect format for field 'id'"));
	}

	@Test
	public void testDeleteEmployeeSuccess() throws Exception {
		// Delete existing employee (id: 2, leaving 1 untouched for updates)
		mvc.perform(delete("/employees/2")
				.header("Authorization", AUTH_HEADER))
				.andExpect(status().isOk());
	}

	@Test
	public void testDeleteEmployeeNotFound() throws Exception {
		mvc.perform(delete("/employees/999")
				.header("Authorization", AUTH_HEADER))
				.andExpect(status().isNotFound())
				.andExpect(status().reason("Employee not found"));
	}
}
