package com.crs.reservation.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RequestMapping(value="/api/v1/guests/")
@FeignClient(name="guest-service-feignclient",url="${guest.url}")
public interface GuestFeignClient {
	
	@GetMapping(value="{guest-id}")
	public ResponseEntity<?> get( @PathVariable(value="guest-id",required=true) String guestId);


}
