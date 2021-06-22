package com.crs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
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

import com.crs.reservation.app.dto.HotelReservationDTO;
import com.crs.reservation.app.dto.SuccessResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ReservationServiceApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class ReservationServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	
	@Sql(statements = { "SET FOREIGN_KEY_CHECKS=0;","INSERT INTO crs.epm_hotel (id, name,region,timings,hotel_status,created_date,modified_date) VALUES ('1', 'HotelA','India','Monday','','2021-06-15 16:30:40.368000','2021-06-15 16:30:40.368000')",
            "INSERT INTO crs.epm_address (address_id, id,city,district,pincode,add_line1,add_line2,state) VALUES ('101', '1','Hyd','RNG','509152','HYD',' ','TS')",
            "INSERT INTO crs.epm_rooms(id,hotel_id,room_type,room_no,room_price) values('2','1','','Room1',1.0)",
			"INSERT INTO guest.ADDRESS (id, add_line1,add_line2,city,district,pincode,state) VALUES ('402849be7a194083017a19408f040001', 'Anjaiah Nagar,Gachibowli','Hyd','Hyd','RNG','500032','TS');",
			"INSERT INTO guest.GUEST (id, document_id,document_type,email_id,mobile_no,name,status,address_id) VALUES ('402849be7a194083017a19408ef50000', '2232 2322 2323 4343','Aadhaar','a@a.com','7388839333','User1','Active','402849be7a194083017a19408f040001')"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = {"DELETE FROM crs.epm_address", "DELETE FROM crs.epm_rooms","DELETE FROM crs.epm_hotel","DELETE FROM guest.ADDRESS;",
			"DELETE FROM guest.GUEST;", "SET FOREIGN_KEY_CHECKS=1;"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	
	@Test
	public void addHotelTest() {
		HotelReservationDTO hotelReservationDTO = prepareReservationDTO();
		ResponseEntity<?> response = restTemplate.postForEntity("http://localhost:" + port + "/api/v1/reservations",
				hotelReservationDTO, SuccessResponse.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

	@Sql(statements = {
			"INSERT INTO  epm_hotel_reservation (reservation_id, account_no, check_in_time,check_out_time,guest_id, guest_mobile_no, guest_name, hotel_id, hotel_name, is_amount_paid, modified_date, reservation_date,room_amount, room_no, room_type, book_status) values('4028aba77a3470d9017a3472343e0000',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL)" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = { "DELETE FROM epm_hotel_reservation" }, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	public void fetchHotelDtlsTest() {
		ResponseEntity<?> response = restTemplate.getForEntity("http://localhost:" + port + "/api/v1/reservations/4028aba77a3470d9017a3472343e0000",
				SuccessResponse.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	private HotelReservationDTO prepareReservationDTO() {
		HotelReservationDTO resrvationDTO = new HotelReservationDTO();
		resrvationDTO.setAccountNo(1234567L);
		resrvationDTO.setCheckInTime(new Date());
		resrvationDTO.setGuestId("402849be7a194083017a19408ef50000");
		resrvationDTO.setHotelId("1");
		resrvationDTO.setRoomNo("Room1");
		resrvationDTO.setGuestMobileNo("9059982249");
		return resrvationDTO;

	}
}
