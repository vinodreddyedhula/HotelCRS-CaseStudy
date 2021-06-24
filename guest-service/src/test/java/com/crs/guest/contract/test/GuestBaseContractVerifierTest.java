package com.crs.guest.contract.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crs.app.guest.dto.GuestDTO;
import com.crs.app.guest.interfaces.GuestApplicationService;
import com.crs.guest.rest.controller.GuestControllerImpl;
import com.google.gson.Gson;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
public class GuestBaseContractVerifierTest {

	private MockMvc mockMvc;

	@Mock
	private GuestApplicationService guestApplicationService;
	
	@InjectMocks
	private GuestControllerImpl guestController;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);

		GuestDTO response = prepareResponse();
		Mockito.when(guestApplicationService.add(Mockito.any())).thenReturn(response);
		Mockito.when(guestApplicationService.update(Mockito.anyString(), Mockito.any())).thenReturn(response);
		Mockito.when(guestApplicationService.fetch(Mockito.anyString())).thenReturn(response);
		Mockito.when(guestApplicationService.delete(Mockito.any())).thenReturn(response);
		mockMvc = MockMvcBuilders.standaloneSetup(guestController).build();
		RestAssuredMockMvc.mockMvc(mockMvc);

	}

	@SuppressWarnings("unchecked")
	private GuestDTO prepareResponse() {
		GuestDTO guestDTO = new GuestDTO();
		String guestDTOJsonString = "{\r\n"
				+ "  \"address\": {\r\n"
				+ "    \"addressLine1\": \"addressLine1\",\r\n"
				+ "    \"addressLine2\": \"addressLine2\",\r\n"
				+ "    \"city\": \"city\",\r\n"
				+ "    \"district\": \"district\",\r\n"
				+ "    \"id\": \"id\",\r\n"
				+ "    \"pinCode\": \"pinCode\",\r\n"
				+ "    \"state\": \"state\"\r\n"
				+ "  },\r\n"
				+ "  \"documentId\": \"documentId\",\r\n"
				+ "  \"documentType\": \"documentType\",\r\n"
				+ "  \"emailId\": \"emailId\",\r\n"
				+ "  \"id\": \"id\",\r\n"
				+ "  \"mobileNumber\": \"mobileNumber\",\r\n"
				+ "  \"name\": \"name\",\r\n"
				+ "  \"status\": \"status\"\r\n"
				+ "}";
		Gson gson = new Gson();
		guestDTO = gson.fromJson(guestDTOJsonString, GuestDTO.class);
		return guestDTO;
	}

}
