package com.crs.guest.integration.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.crs.app.guest.dto.AddressDTO;
import com.crs.app.guest.dto.GuestDTO;
import com.crs.app.guest.dto.SuccessResponse;
import com.crs.guest.service.GuestSpringBootApplicationService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GuestSpringBootApplicationService.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class GuestIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testAddGuest() throws Exception {
		GuestDTO guestDTO = prepareGuestDTO();
		ResponseEntity<?> response = restTemplate.postForEntity("http://localhost:" + port + "/api/v1/guest", guestDTO,
				SuccessResponse.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Sql(statements = { "SET FOREIGN_KEY_CHECKS=0;",
			"INSERT INTO ADDRESS (id, add_line1,add_line2,city,district,pincode,state) VALUES ('402849be7a194083017a19408f040001', 'Anjaiah Nagar,Gachibowli','Hyd','Hyd','RNG','500032','TS');",
			"INSERT INTO GUEST (id, document_id,document_type,email_id,mobile_no,name,status,address_id) VALUES ('402849be7a194083017a19408ef50000', '2232 2322 2323 4343','Aadhaar','a@a.com','7388839333','User1','Active','402849be7a194083017a19408f040001');" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = {  "DELETE FROM ADDRESS;",
			"DELETE FROM GUEST;", "SET FOREIGN_KEY_CHECKS=1;"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	public void testUpdateGuest() throws Exception {
		GuestDTO guestDTO = prepareGuestDTO();
		guestDTO.setName("Aravind Reddy");
		restTemplate.put("http://localhost:" + port + "/api/v1/guest/402849be7a194083017a19408ef50000", guestDTO);
		ResponseEntity<?> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/api/v1/guest/402849be7a194083017a19408ef50000", SuccessResponse.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Sql(statements = { "SET FOREIGN_KEY_CHECKS=0;",
			"INSERT INTO ADDRESS (id, add_line1,add_line2,city,district,pincode,state) VALUES ('402849be7a194083017a19408f040001', 'Anjaiah Nagar,Gachibowli','Hyd','Hyd','RNG','500032','TS');",
			"INSERT INTO GUEST (id, document_id,document_type,email_id,mobile_no,name,status,address_id) VALUES ('402849be7a194083017a19408ef50000', '2232 2322 2323 4343','Aadhaar','a@a.com','7388839333','User1','Active','402849be7a194083017a19408f040001');" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = {  "DELETE FROM ADDRESS;",
			"DELETE FROM GUEST;", "SET FOREIGN_KEY_CHECKS=1;"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	public void testFetchGuest() throws Exception {
		ResponseEntity<?> response = restTemplate.getForEntity(
				"http://localhost:" + port + "/api/v1/guest/402849be7a194083017a19408ef50000", SuccessResponse.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Sql(statements = { "SET FOREIGN_KEY_CHECKS=0;",
			"INSERT INTO ADDRESS (id, add_line1,add_line2,city,district,pincode,state) VALUES ('402849be7a194083017a19408f040001', 'Anjaiah Nagar,Gachibowli','Hyd','Hyd','RNG','500032','TS');",
			"INSERT INTO GUEST (id, document_id,document_type,email_id,mobile_no,name,status,address_id) VALUES ('402849be7a194083017a19408ef50000', '2232 2322 2323 4343','Aadhaar','a@a.com','7388839333','User1','Active','402849be7a194083017a19408f040001');" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = {  "DELETE FROM ADDRESS;",
			"DELETE FROM GUEST;", "SET FOREIGN_KEY_CHECKS=1;"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	public void testDeleteGuest() throws Exception {
		restTemplate.delete("http://localhost:" + port + "/api/v1/guest/402849be7a194083017a19408ef50000");
	}

	private GuestDTO prepareGuestDTO() {
		GuestDTO dto = new GuestDTO();
		dto.setId("402849be7a194083017a19408ef50000");
		dto.setName("User1");
		dto.setMobileNumber("7388839333");
		dto.setEmailId("a@a.com");
		dto.setDocumentType("Aadhaar");
		dto.setDocumentId("2232 2322 2323 4343");
		dto.setStatus("Active");
		AddressDTO address = new AddressDTO();
		address.setDistrict("RNG");
		address.setCity("Hyd");
		address.setPinCode("500032");
		address.setAddressLine1("Anjaiah Nagar,Gachibowli");
		address.setState("TS");
		address.setId("402849be7a194083017a19408f040001");
		dto.setAddress(address);
		return dto;
	}

}
