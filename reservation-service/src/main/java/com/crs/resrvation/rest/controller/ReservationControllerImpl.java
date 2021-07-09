package com.crs.resrvation.rest.controller;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crs.reservation.app.dto.HotelReservationDTO;
import com.crs.reservation.app.dto.HotelReservationResponse;
import com.crs.reservation.app.dto.SuccessResponse;
import com.crs.reservation.app.interfaces.ReservationAppService;
import com.crs.reservation.app.interfaces.ReservationController;
import com.crs.reservation.cqrs.service.HotelReservationCommandService;
import com.crs.reservation.cqrs.service.HotelReservationQueryService;

@RestController
@RequestMapping(value="/api/v1/",produces="application/json")
public class ReservationControllerImpl implements ReservationController{
	
	@Autowired
	private ReservationAppService reservationService;
	
	@Autowired
	private HotelReservationCommandService reservationCommandService;
	
	@Autowired
	private HotelReservationQueryService reservationQueryService;
		
	@Override
	@PostMapping("reservations")
	public ResponseEntity<SuccessResponse<HotelReservationResponse>> doHotelReservation(
			  @Valid @RequestBody HotelReservationDTO resrvationDTO) {
	return ResponseEntity.ok(new SuccessResponse<HotelReservationResponse>(reservationService.doReservation(resrvationDTO)));
	}
	
	@Override
	@GetMapping("reservations/{reservation-id}")
	public ResponseEntity<SuccessResponse<HotelReservationResponse>> getReservationDetails(
			 @Valid  @PathVariable(value="reservation-id",required=true) String reservationId) {
	return ResponseEntity.ok(new SuccessResponse<HotelReservationResponse>(reservationService.getReservationDetails(reservationId)));
	}
	

	@PostMapping("cqrs/reservation")
	public CompletableFuture<HotelReservationResponse> reserveRoom(
			  @Valid @RequestBody HotelReservationDTO resrvationDTO) {
          return  reservationCommandService.createReservation(resrvationDTO);
	}
	

	@GetMapping("cqrs/reservations/{reservation-id}")
	public CompletableFuture<HotelReservationResponse> getHotelReservationDetails(
			 @Valid  @PathVariable(value="reservation-id",required=true) String reservationId) {
	return reservationQueryService.findById(reservationId);
	}
}
