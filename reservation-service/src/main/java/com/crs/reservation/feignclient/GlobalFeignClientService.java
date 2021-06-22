package com.crs.reservation.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crs.reservation.app.dto.CommonRestAPIHelper;
import com.crs.reservation.app.dto.GuestDTO;
import com.crs.reservation.app.dto.HotelResponseDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Service("globalFeignClientService")
@Slf4j
public class GlobalFeignClientService {
	
	@Autowired
	private HotelFeignClient hotelFeignClient;
	
	@Autowired
	private GuestFeignClient guestFeignClient;
	
	
	@CircuitBreaker(name="hotel-service",fallbackMethod="hotelservicefallback")
	public HotelResponseDTO getHotelDetails(String hotelId) {
		ResponseEntity<?> hotelDetails=hotelFeignClient.getHotelDetails(hotelId);
		return (HotelResponseDTO) CommonRestAPIHelper.getResponse(hotelDetails,HotelResponseDTO.class);
	}
	
	@CircuitBreaker(name="guest-service",fallbackMethod="guestservicefallback")
	public GuestDTO  getGuestDetails(String guestId) {
		ResponseEntity<?> guestDetails=guestFeignClient.get(guestId);
		return (GuestDTO) CommonRestAPIHelper.getResponse(guestDetails,GuestDTO.class);
	}
	
	public HotelResponseDTO hotelservicefallback(String hotelId,Throwable t) {
		log.info("Exception is",t.getCause());
		return new HotelResponseDTO();
	}
	

	public GuestDTO guestservicefallback(String guestId,Throwable t) {
		log.info("Exception is",t.getCause());
		return new GuestDTO();
		
	}

}
