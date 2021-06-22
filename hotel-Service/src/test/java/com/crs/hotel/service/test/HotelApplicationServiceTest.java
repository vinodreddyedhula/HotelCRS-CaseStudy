package com.crs.hotel.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.crs.app.hotel.dto.AddressDTO;
import com.crs.app.hotel.dto.HotelDTO;
import com.crs.app.hotel.dto.HotelResponseDTO;
import com.crs.app.hotel.dto.RoomDTO;
import com.crs.app.hotel.enums.RoomType;
import com.crs.app.hotel.interfaces.HotelApplicationService;
import com.crs.hotel.exception.BusinessException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelApplicationServiceTest {
	
	@Autowired
	private HotelApplicationService hotelService;
	
	@Test
	public void addHotelDetailsTest() {
		HotelResponseDTO response=hotelService.addHotel(prepareHotelDTO());
		assertNotNull(response);
	}
	
	@Test
	public void updateHotelDetailsTest() {
		String hotelId="402881e57a0eafbe017a0eafcc820000";
		HotelDTO hotelDTO=prepareHotelDTO();
		hotelDTO.setKey(hotelId);
		HotelResponseDTO response=hotelService.updateHotel(hotelDTO,hotelId);
		assertEquals(hotelId,response.getKey());
	}
	
	
	@Sql(statements = { "INSERT INTO epm_hotel (id, name,region,timings,hotel_status,created_date,modified_date) VALUES ('1', 'HotelA','India','Monday','','2021-06-15 16:30:40.368000','2021-06-15 16:30:40.368000')",
            "INSERT INTO epm_address (address_id, id,city,district,pincode,add_line1,add_line2,state) VALUES ('101', '1','Hyd','RNG','509152','HYD',' ','TS')",
            "INSERT INTO epm_rooms(id,hotel_id,room_type,room_no,room_price) values('2','1','','Room1',1.0)"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = {"DELETE FROM epm_address", "DELETE FROM epm_rooms","DELETE FROM epm_hotel"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	public void deleteHotelDetailsTest() {
		String hotelId="1";
		HotelResponseDTO response=hotelService.deleteHotelDetails(hotelId);
		assertNotNull(response);
	}
	
	@Sql(statements = { "INSERT INTO epm_hotel (id, name,region,timings,hotel_status,created_date,modified_date) VALUES ('1', 'HotelA','India','Monday','','2021-06-15 16:30:40.368000','2021-06-15 16:30:40.368000')",
            "INSERT INTO epm_address (address_id, id,city,district,pincode,add_line1,add_line2,state) VALUES ('101', '1','Hyd','RNG','509152','HYD',' ','TS')",
            "INSERT INTO epm_rooms(id,hotel_id,room_type,room_no,room_price) values('2','1','','Room1',1.0)"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = {"DELETE FROM epm_address", "DELETE FROM epm_rooms","DELETE FROM epm_hotel"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	@Test
	public void fetchHotelDtlsTest() {
		String hotelId="1";
		HotelResponseDTO response=hotelService.fetchHotelDtls(hotelId);
		assertEquals(hotelId,response.getKey());
	}
	
	/*
	 * @Test(expected = BusinessException.class) public void
	 * validationExceptionTest() { String
	 * hotelId="402881e57a0eafbe017a0eafcc820023"; HotelResponseDTO
	 * response=hotelService.fetchHotelDtls(hotelId); }
	 */

	private HotelDTO prepareHotelDTO() {
		HotelDTO dto=new HotelDTO();
		  dto.setHotelName("Radisson");
		  dto.setRegion("India");
          dto.setStatus("Available");
          dto.setTimings("Mon-Sun(24/7)");
          AddressDTO address =new AddressDTO();
          address.setDistrict("RNG");
          address.setCity("Hyd");
          address.setPinCode("500032");
          address.setAddressLine1("Anjaiah Nagar,Gachibowli");
          address.setState("TS");
          dto.setAddress(address);
          Set<RoomDTO> rooms=new HashSet<RoomDTO>();
          RoomDTO room1=new RoomDTO();
          room1.setRoomNo("R101");
          room1.setRoomPrice(BigDecimal.ONE);
          room1.setRoomType(RoomType.NORMAL.toString());
          rooms.add(room1);
          dto.setRoomsInfo(rooms);
		return dto;
	}

}
