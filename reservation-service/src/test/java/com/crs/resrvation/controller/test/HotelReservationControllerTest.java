package com.crs.resrvation.controller.test;

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

import com.crs.reservation.app.dto.HotelReservationDTO;
import com.crs.reservation.app.dto.HotelReservationResponse;
import com.crs.reservation.app.interfaces.ReservationAppService;
import com.crs.resrvation.rest.controller.ReservationControllerImpl;

@RunWith(MockitoJUnitRunner.class)
public class HotelReservationControllerTest {
	

	private MockMvc mockMvc;

	@InjectMocks
	private ReservationControllerImpl hotelReservationController;

	@Mock
	private ReservationAppService hotelAppService;

	@Before
	public void setup() {
		HotelReservationResponse response = new HotelReservationResponse();
		Mockito.when(hotelAppService.doReservation(Mockito.any())).thenReturn(response);
		Mockito.when(hotelAppService.getReservationDetails(Mockito.anyString())).thenReturn(response);
		mockMvc = MockMvcBuilders.standaloneSetup(hotelReservationController).build();
	}

	@Test
	public void addReservationDtlsTest() throws Exception {
		String reqJson = "{\r\n"
				+ "  \"accountNo\": 12345,\r\n"
				+ "  \"checkInTime\": \"2021-06-22T13:46:13.163Z\",\r\n"
				+ "  \"checkOutTime\": \"2021-06-22T13:46:13.163Z\",\r\n"
				+ "  \"guestId\": \"4028aba77a339206017a33c43f0a0001\",\r\n"
				+ "  \"guestMobileNo\": \"9059982249\",\r\n"
				+ "  \"guestName\": \"Vinod Reddy\",\r\n"
				+ "  \"hotelId\": \"4028aba77a3398ac017a33c57a810001\",\r\n"
				+ "  \"hotelName\": \"Radisson\",\r\n"
				+ "  \"roomNo\": \"123\"\r\n"
				+ "}";

		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/v1/reservations").contentType(MediaType.APPLICATION_JSON).content(reqJson))
				.andExpect(status().is(200));
	}
	
	@Test
	public void fetchReservationDtlsTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/reservations/4028aba77a33f6de017a33fa65f10000")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
