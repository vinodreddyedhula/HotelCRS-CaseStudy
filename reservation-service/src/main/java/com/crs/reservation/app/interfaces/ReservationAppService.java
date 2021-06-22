package com.crs.reservation.app.interfaces;

import com.crs.reservation.app.dto.HotelReservationDTO;
import com.crs.reservation.app.dto.HotelReservationResponse;

public interface ReservationAppService {
	
	public 	HotelReservationResponse doReservation(HotelReservationDTO resrvationDTO);

	public HotelReservationResponse getReservationDetails(String reservationId);

}
