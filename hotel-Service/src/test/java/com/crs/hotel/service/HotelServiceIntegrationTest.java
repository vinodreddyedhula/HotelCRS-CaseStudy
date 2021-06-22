package com.crs.hotel.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.crs.app.hotel.dto.AddressDTO;
import com.crs.app.hotel.dto.HotelDTO;
import com.crs.app.hotel.dto.RoomDTO;
import com.crs.app.hotel.dto.SuccessResponse;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelSpringBootApplicationService.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class HotelServiceIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void addHotelTest() {
		HotelDTO hotelDTO = prepareHotelDTO();
		ResponseEntity<?> response = restTemplate
				.postForEntity("http://localhost:" + port + "/api/v1/hotels", hotelDTO, SuccessResponse.class);
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}

	@Sql(statements = { "INSERT INTO epm_hotel (id, name,region,timings,hotel_status,created_date,modified_date) VALUES ('1', 'HotelA','India','Monday','','2021-06-15 16:30:40.368000','2021-06-15 16:30:40.368000')",
            "INSERT INTO epm_address (address_id, id,city,district,pincode,add_line1,add_line2,state) VALUES ('101', '1','Hyd','RNG','509152','HYD',' ','TS')",
            "INSERT INTO epm_rooms(id,hotel_id,room_type,room_no,room_price) values('2','1','','Room1',1.0)"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = {"DELETE FROM epm_address", "DELETE FROM epm_rooms","DELETE FROM epm_hotel"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	public void updateHotelTest() {
		String id = "1";
		HotelDTO hotelDTO = prepareHotelDTO();
		hotelDTO.setHotelName("Trident");
		restTemplate.put("http://localhost:" + port + "/api/v1/hotels/1", hotelDTO);
		ResponseEntity<?> response = restTemplate
				.getForEntity("http://localhost:" + port + "/api/v1/hotels/1", SuccessResponse.class);
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}

	@Sql(statements = { "INSERT INTO epm_hotel (id, name,region,timings,hotel_status,created_date,modified_date) VALUES ('1', 'HotelA','India','Monday','','2021-06-15 16:30:40.368000','2021-06-15 16:30:40.368000')",
            "INSERT INTO epm_address (address_id, id,city,district,pincode,add_line1,add_line2,state) VALUES ('101', '1','Hyd','RNG','509152','HYD',' ','TS')",
            "INSERT INTO epm_rooms(id,hotel_id,room_type,room_no,room_price) values('2','1','','Room1',1.0)"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = {"DELETE FROM epm_address", "DELETE FROM epm_rooms","DELETE FROM epm_hotel"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	public void fetchHotelDtlsTest() {
		ResponseEntity<?> response = restTemplate
				.getForEntity("http://localhost:" + port + "/api/v1/hotels/1", SuccessResponse.class);
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}

	@Sql(statements = { "INSERT INTO epm_hotel (id, name,region,timings,hotel_status,created_date,modified_date) VALUES ('1', 'HotelA','India','Monday','','2021-06-15 16:30:40.368000','2021-06-15 16:30:40.368000')",
            "INSERT INTO epm_address (address_id, id,city,district,pincode,add_line1,add_line2,state) VALUES ('101', '1','Hyd','RNG','509152','HYD',' ','TS')",
            "INSERT INTO epm_rooms(id,hotel_id,room_type,room_no,room_price) values('2','1','','Room1',1.0)",
            "INSERT INTO epm_hotel (id, name,region,timings,hotel_status,created_date,modified_date) VALUES ('101', 'HotelA','India','Monday','','2021-06-15 16:30:40.368000','2021-06-15 16:30:40.368000')"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = {"DELETE FROM epm_address", "DELETE FROM epm_rooms","DELETE FROM epm_hotel"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	public void deleteHotelDtlsTest() {
		restTemplate.delete("http://localhost:" + port + "/api/v1/hotels/1");
		ResponseEntity<?> response = restTemplate
				.getForEntity("http://localhost:" + port + "/api/v1/hotels/101", SuccessResponse.class);
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}

	private HotelDTO prepareHotelDTO() {
		HotelDTO dto = new HotelDTO();
		dto.setHotelName("Radisson");
		dto.setRegion("India");
		dto.setStatus("Available");
		dto.setTimings("Mon-Sun(24/7)");
		AddressDTO address = new AddressDTO();
		address.setDistrict("RNG");
		address.setCity("Hyd");
		address.setPinCode("500032");
		address.setAddressLine1("Anjaiah Nagar,Gachibowli");
		address.setState("TS");
		dto.setAddress(address);
		Set<RoomDTO> rooms = new HashSet<RoomDTO>();
		RoomDTO room1 = new RoomDTO();
		room1.setRoomNo("R101");
		room1.setRoomPrice(BigDecimal.ONE);
		room1.setRoomType("Normal");
		rooms.add(room1);
		dto.setRoomsInfo(rooms);
		return dto;
	}

}
