package com.crs.reservation.contract.test;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.crs.ReservationServiceApplication;
import com.crs.reservation.app.dto.CommonRestAPIHelper;
import com.crs.reservation.app.dto.HotelResponseDTO;
import com.crs.reservation.feignclient.HotelFeignClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ReservationServiceApplication.class)
@AutoConfigureMockMvc
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com:hotel-Service:+:stubs:8096")
public class HotelServiceContractTest {

	@Autowired
	private HotelFeignClient hotelFeignClient;

	@Sql(statements = { "SET FOREIGN_KEY_CHECKS=0;",
			"INSERT INTO crs.epm_hotel (id, name,region,timings,hotel_status,created_date,modified_date) VALUES ('1', 'HotelA','India','Monday','','2021-06-15 16:30:40.368000','2021-06-15 16:30:40.368000')",
			"INSERT INTO crs.epm_address (address_id, id,city,district,pincode,add_line1,add_line2,state) VALUES ('101', '1','Hyd','RNG','509152','HYD',' ','TS')",
			"INSERT INTO crs.epm_rooms(id,hotel_id,room_type,room_no,room_price) values('2','1','','Room1',1.0)",
			"INSERT INTO guest.ADDRESS (id, add_line1,add_line2,city,district,pincode,state) VALUES ('402849be7a194083017a19408f040001', 'Anjaiah Nagar,Gachibowli','Hyd','Hyd','RNG','500032','TS');",
			"INSERT INTO guest.GUEST (id, document_id,document_type,email_id,mobile_no,name,status,address_id) VALUES ('402849be7a194083017a19408ef50000', '2232 2322 2323 4343','Aadhaar','a@a.com','7388839333','User1','Active','402849be7a194083017a19408f040001')" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = { "DELETE FROM crs.epm_address", "DELETE FROM crs.epm_rooms", "DELETE FROM crs.epm_hotel",
			"DELETE FROM guest.ADDRESS;", "DELETE FROM guest.GUEST;",
			"SET FOREIGN_KEY_CHECKS=1;" }, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

	@Test
	public void testHotelServiceContract() {

		ResponseEntity<?> hotelDetails = hotelFeignClient.getHotelDetails("1");
		HotelResponseDTO responseData = (HotelResponseDTO) CommonRestAPIHelper.getResponse(hotelDetails,
				HotelResponseDTO.class);
		assertNotNull(hotelDetails);
		assertNotNull(responseData);
	}

}
