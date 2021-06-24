package com.crs.hotel.contract.testing;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crs.app.hotel.dto.HotelResponseDTO;
import com.crs.app.hotel.interfaces.HotelApplicationService;
import com.crs.hotel.rest.controller.HotelControllerImpl;
import com.google.gson.Gson;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
public class GlobalBaseContractTest {

	private MockMvc mockMvc;

	@InjectMocks
	private HotelControllerImpl hotelController;

	@Mock
	private HotelApplicationService hotelAppService;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);

		HotelResponseDTO response = prepareResponse();
		Mockito.when(hotelAppService.addHotel(Mockito.any())).thenReturn(response);
		Mockito.when(hotelAppService.updateHotel(Mockito.any(), Mockito.anyString())).thenReturn(response);
		Mockito.when(hotelAppService.fetchHotelDtls(Mockito.anyString())).thenReturn(response);
		Mockito.when(hotelAppService.deleteHotelDetails(Mockito.any())).thenReturn(response);
		mockMvc = MockMvcBuilders.standaloneSetup(hotelController).build();
		RestAssuredMockMvc.mockMvc(mockMvc);

	}

	private HotelResponseDTO prepareResponse() {
		HotelResponseDTO response = new HotelResponseDTO();
		String jsonString = "{\r\n"
				+ "    \"address\": {\r\n"
				+ "      \"addressLine1\": \"addressLine1\",\r\n"
				+ "      \"addressLine2\": \"addressLine2\",\r\n"
				+ "      \"city\": \"city\",\r\n"
				+ "      \"district\": \"district\",\r\n"
				+ "      \"pinCode\": \"pinCode\",\r\n"
				+ "      \"state\": \"state\"\r\n"
				+ "    },\r\n"
				+ "    \"hotelName\": \"hotelName\",\r\n"
				+ "    \"key\": \"key\",\r\n"
				+ "    \"message\": \"message\",\r\n"
				+ "    \"region\": \"region\",\r\n"
				+ "    \"roomsInfo\": [\r\n"
				+ "      {\r\n"
				+ "        \"roomNo\": \"roomNo\",\r\n"
				+ "        \"roomPrice\": 1.1,\r\n"
				+ "        \"roomType\": \"roomType\"\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"status\": \"status\",\r\n"
				+ "    \"statusCode\": \"statusCode\",\r\n"
				+ "    \"timings\": \"timings\"\r\n"
				+ "  }";

		Gson gson = new Gson();
		response = gson.fromJson(jsonString, HotelResponseDTO.class);
		return response;
	}

}
