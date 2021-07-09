package com.crs.reservation.cqrs.command;

import java.util.Date;
import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@NoArgsConstructor  
@AllArgsConstructor
public class CreateReservationCommand {
	
	  @TargetAggregateIdentifier
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
