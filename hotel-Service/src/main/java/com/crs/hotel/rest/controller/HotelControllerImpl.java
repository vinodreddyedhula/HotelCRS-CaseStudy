package com.crs.hotel.rest.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crs.app.hotel.dto.HotelDTO;
import com.crs.app.hotel.dto.HotelResponseDTO;
import com.crs.app.hotel.dto.SuccessResponse;
import com.crs.app.hotel.interfaces.HotelApplicationService;
import com.crs.app.hotel.interfaces.HotelController;

@RestController
@RequestMapping(value="/api/v1/",produces="application/json")
public class HotelControllerImpl implements HotelController{
	
	  @Autowired 
	  private HotelApplicationService hotelAppService;
	 
	@Override
	@PostMapping("hotels")
	public ResponseEntity<SuccessResponse<HotelResponseDTO>> addHotel(
			  @Valid @RequestBody HotelDTO hotelDto) {
		return ResponseEntity.ok(new SuccessResponse<HotelResponseDTO>(hotelAppService.addHotel(hotelDto)));
	}
	
	@Override
	@GetMapping("hotels/{hotel-id}")
	public ResponseEntity<SuccessResponse<HotelResponseDTO>> getHotelDetails( @PathVariable(value="hotel-id",required=true) String hotelId) {	
		return ResponseEntity.ok(new SuccessResponse<HotelResponseDTO>(hotelAppService.fetchHotelDtls(hotelId)));
	}

	@Override
	@DeleteMapping("hotels/{hotel-id}")
	public ResponseEntity<SuccessResponse<HotelResponseDTO>> deleteHotelDetails(@NotNull @PathVariable(value="hotel-id",required=true) String hotelId) {
		return ResponseEntity.ok(new SuccessResponse<HotelResponseDTO>(hotelAppService.deleteHotelDetails(hotelId)));
	}
	
	@Override
	@PutMapping("hotels/{hotel-id}")
	public ResponseEntity<SuccessResponse<HotelResponseDTO>> updateHotel(@Valid @RequestBody HotelDTO hotelDTO,
			@NotNull @PathVariable(value="hotel-id",required=true) String hotelId) {
		return ResponseEntity.ok(new SuccessResponse<HotelResponseDTO>(hotelAppService.updateHotel(hotelDTO,hotelId)));
	}
	


}
