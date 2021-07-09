package com.crs.reservation.cqrs.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import com.crs.reservation.app.dto.HotelReservationResponse;
import com.crs.reservation.cqrs.command.GetReservationDetailsQuery;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HotelReservationQueryService {

	private final QueryGateway queryGateway;

	public CompletableFuture<HotelReservationResponse> findById(String reservationId) {

		return this.queryGateway.query(new GetReservationDetailsQuery(formatUuid(reservationId)),
				ResponseTypes.instanceOf(HotelReservationResponse.class));
	}
	
	
	
	   public static UUID formatUuid(String accountId) {
	        accountId = accountId.replace("-", "");
	        String formatted = String.format(
	                accountId.substring(0, 8) + "-" +
	                        accountId.substring(8, 12) + "-" +
	                        accountId.substring(12, 16) + "-" +
	                        accountId.substring(16, 20) + "-" +
	                        accountId.substring(20, 32)
	        );
	        return UUID.fromString(formatted);
	    }

}
