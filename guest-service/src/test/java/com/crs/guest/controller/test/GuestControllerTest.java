package com.crs.guest.controller.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crs.app.guest.interfaces.GuestApplicationService;
import com.crs.guest.rest.controller.GuestControllerImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class GuestControllerTest {

	private MockMvc mockMvc;

	@Mock
	private GuestApplicationService guestApplicationService;

	@InjectMocks
	private GuestControllerImpl guestController;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(guestController).build();
	}

	@Test
	public void testAddGuest() throws Exception {
		String reqJson = "​​{\r\n" + "    \"id\": \"402881907a141d9f017a1421a0f70000\",\r\n"
				+ "    \"name\": \"Aravind\",\r\n" + "    \"mobileNumber\": \"7748800393\",\r\n"
				+ "    \"emailId\": \"a@a.com\",\r\n" + "    \"documentType\": \"Aadhaar1\",\r\n"
				+ "    \"documentId\": \"3342 4343 2323 5453\",\r\n" + "    \"address\": {\r\n"
				+ "      \"id\": \"402881907a141d9f017a1421a1010001\",\r\n" + "      \"city\": \"test1\",\r\n"
				+ "      \"state\": \"test1\",\r\n" + "      \"district\": \"test\",\r\n"
				+ "      \"addressLine1\": \"test\",\r\n" + "      \"addressLine2\": \"test\",\r\n"
				+ "      \"pinCode\": \"test\"\r\n" + "    },\r\n" + "    \"status\": \"Active\"\r\n" + "  }";
		mockMvc.perform(
				MockMvcRequestBuilders.post("/api/v1/guest").contentType(MediaType.APPLICATION_JSON).content(reqJson))
				.andExpect(response -> {
					log.info(response.toString());
				});
	}

	@Test
	public void testUpdateGuest() throws Exception {
		String reqJson = "{\r\n" + "    \"id\": \"402881907a141d9f017a1421a0f70000\",\r\n"
				+ "    \"name\": \"Aravind\",\r\n" + "    \"mobileNumber\": \"7748800393\",\r\n"
				+ "    \"emailId\": \"a@a.com\",\r\n" + "    \"documentType\": \"Aadhaar1\",\r\n"
				+ "    \"documentId\": \"3342 4343 2323 5453\",\r\n" + "    \"address\": {\r\n"
				+ "      \"id\": \"402881907a141d9f017a1421a1010001\",\r\n" + "      \"city\": \"test1\",\r\n"
				+ "      \"state\": \"test1\",\r\n" + "      \"district\": \"test\",\r\n"
				+ "      \"addressLine1\": \"test\",\r\n" + "      \"addressLine2\": \"test\",\r\n"
				+ "      \"pinCode\": \"test\"\r\n" + "    },\r\n" + "    \"status\": \"Active\"\r\n" + "  }";
		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/guest/12345678901").contentType(MediaType.APPLICATION_JSON)
				.content(reqJson)).andExpect(status().is(200));
	}

	@Test
	public void testFetchGuest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/guest/12345678901")).andExpect(status().is(200));
	}

	@Test
	public void testDeleteGuest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/guest/12345678901")).andExpect(status().is(200));
	}

}
