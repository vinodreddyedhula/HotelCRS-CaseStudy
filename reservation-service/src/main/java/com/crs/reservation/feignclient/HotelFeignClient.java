package com.crs.reservation.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RequestMapping(value="/api/v1/hotels/")
@FeignClient(name="hotel-Service",url="${hotel.url}")
public interface HotelFeignClient {
	
	@GetMapping(value="{hotel-id}")
	public ResponseEntity<?> getHotelDetails( @PathVariable(value="hotel-id",required=true) String hotelId);
	
}
