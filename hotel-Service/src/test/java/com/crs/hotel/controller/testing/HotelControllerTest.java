package com.crs.hotel.controller.testing;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crs.app.hotel.dto.HotelResponseDTO;
import com.crs.app.hotel.interfaces.HotelApplicationService;
import com.crs.hotel.rest.controller.HotelControllerImpl;

@RunWith(MockitoJUnitRunner.class)
public class HotelControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private HotelControllerImpl hotelController;

	@Mock
	private HotelApplicationService hotelAppService;

	@Before
	public void setup() {
		HotelResponseDTO response = new HotelResponseDTO();
		Mockito.when(hotelAppService.addHotel(Mockito.any())).thenReturn(response);
		Mockito.when(hotelAppService.updateHotel(Mockito.any(), Mockito.anyString())).thenReturn(response);
		Mockito.when(hotelAppService.fetchHotelDtls(Mockito.anyString())).thenReturn(response);
		Mockito.when(hotelAppService.deleteHotelDetails(Mockito.any())).thenReturn(response);
		mockMvc = MockMvcBuilders.standaloneSetup(hotelController).build();
	}

	@Test
	public void addHotelTest() throws Exception {
		String reqJson ="{\r\n"
				+ "  \"address\": {\r\n"
				+ "    \"addressLine1\": \"string\",\r\n"
				+ "    \"addressLine2\": \"string\",\r\n"
				+ "    \"city\": \"string\",\r\n"
				+ "    \"district\": \"string\",\r\n"
				+ "    \"pinCode\": \"string\",\r\n"
				+ "    \"state\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"hotelName\": \"string\",\r\n"
				+ "  \"key\": \"string\",\r\n"
				+ "  \"region\": \"string\",\r\n"
				+ "  \"roomsInfo\": [\r\n"
				+ "    {\r\n"
				+ "      \"roomNo\": \"string\",\r\n"
				+ "      \"roomPrice\": 0,\r\n"
				+ "      \"roomType\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"string\",\r\n"
				+ "  \"timings\": \"string\"\r\n"
				+ "}";

		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/v1/hotels").contentType(MediaType.APPLICATION_JSON).content(reqJson))
				.andExpect(status().is(200));
	}

	@Test
	public void updateHotelTest() throws Exception {
		String reqJson = "{\r\n"
				+ "  \"address\": {\r\n"
				+ "    \"addressLine1\": \"string\",\r\n"
				+ "    \"addressLine2\": \"string\",\r\n"
				+ "    \"city\": \"string\",\r\n"
				+ "    \"district\": \"string\",\r\n"
				+ "    \"pinCode\": \"string\",\r\n"
				+ "    \"state\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"hotelName\": \"string\",\r\n"
				+ "  \"key\": \"string\",\r\n"
				+ "  \"region\": \"string\",\r\n"
				+ "  \"roomsInfo\": [\r\n"
				+ "    {\r\n"
				+ "      \"roomNo\": \"string\",\r\n"
				+ "      \"roomPrice\": 0,\r\n"
				+ "      \"roomType\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"string\",\r\n"
				+ "  \"timings\": \"string\"\r\n"
				+ "}";

		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/hotels/hotel-id").contentType(MediaType.APPLICATION_JSON)
				.content(reqJson)).andExpect(status().is(200));
	}

	@Test
	public void deleteHotelTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/hotels/402881e57a0eafbe017a0eafcd0e0003")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void fetchHotelDtlsTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/hotels/402881e57a0eafbe017a0eafcd0e0003")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
