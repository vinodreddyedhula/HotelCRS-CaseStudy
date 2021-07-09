package com.crs.reservation.cqrs.events;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HotelReservationEvent {
	
	  private String reservationId;
	  private String hotelName;
	  private String hotelId;
	  private String guestId;
	  private String guestMobileNo;
	  private String guestName;
	  private String roomNo;
	  private Date checkInTime;
	  private Date checkOutTime;
	  private Long accountNo;

}
