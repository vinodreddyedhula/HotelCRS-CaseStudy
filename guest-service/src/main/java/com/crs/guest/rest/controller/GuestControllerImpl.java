package com.crs.guest.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.crs.app.guest.dto.GuestDTO;
import com.crs.app.guest.dto.SuccessResponse;
import com.crs.app.guest.interfaces.GuestApplicationService;
import com.crs.app.guest.interfaces.GuestController;

@RestController
public class GuestControllerImpl implements GuestController {

	@Autowired
	private GuestApplicationService guestApplicationService;

	@Override 
	public ResponseEntity<SuccessResponse<GuestDTO>> add(GuestDTO guestDTO) {
		return ResponseEntity.ok(new SuccessResponse(guestApplicationService.add(guestDTO)));
	}

	@Override
	public ResponseEntity<SuccessResponse<GuestDTO>> update(GuestDTO guestDTO, String id) {
		guestApplicationService.update(id ,guestDTO);
		return ResponseEntity.ok(new SuccessResponse(guestDTO));
	}

	@Override
	public ResponseEntity<SuccessResponse<GuestDTO>> get(String id) {
		return ResponseEntity.ok(new SuccessResponse(guestApplicationService.fetch(id)));
	}

	@Override
	public ResponseEntity<SuccessResponse<GuestDTO>> delete(String id) {
		return ResponseEntity.ok(new SuccessResponse(guestApplicationService.delete(id)));
	}
}
