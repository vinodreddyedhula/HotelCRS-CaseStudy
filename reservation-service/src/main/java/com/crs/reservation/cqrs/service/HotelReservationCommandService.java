package com.crs.reservation.cqrs.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.crs.reservation.app.dto.HotelReservationDTO;
import com.crs.reservation.app.dto.HotelReservationResponse;
import com.crs.reservation.cqrs.command.CreateReservationCommand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HotelReservationCommandService {
	
	    private final CommandGateway commandGateway;

	    public CompletableFuture<HotelReservationResponse> createReservation(HotelReservationDTO reservationDTO) {
	        return this.commandGateway.send(new CreateReservationCommand(
	        		UUID.randomUUID().toString(),
	                reservationDTO.getHotelId(),
	                reservationDTO.getHotelName(),
	                reservationDTO.getGuestId(),
	                reservationDTO.getGuestMobileNo(),
	                reservationDTO.getGuestName(),
	                reservationDTO.getRoomNo(),
	                reservationDTO.getCheckInTime(),
	                reservationDTO.getCheckOutTime(),
	                reservationDTO.getAccountNo()
	        ));
	    }
	    
}
