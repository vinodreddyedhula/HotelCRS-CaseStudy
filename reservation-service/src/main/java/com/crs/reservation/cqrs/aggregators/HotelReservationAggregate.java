package com.crs.reservation.cqrs.aggregators;

import java.util.Date;
import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.crs.reservation.cqrs.command.CreateReservationCommand;
import com.crs.reservation.cqrs.events.HotelReservationEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class HotelReservationAggregate {
	
	  @AggregateIdentifier
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
	  
	  @CommandHandler
	  public HotelReservationAggregate(CreateReservationCommand command) {
		  
		  AggregateLifecycle.apply(
		            new HotelReservationEvent(
		            		command.getReservationId(),
		            		command.getHotelId(),
		            		command.getHotelName(),
		            		command.getGuestId(),
		            		command.getGuestMobileNo(),
		            		command.getGuestName(),
		            		command.getRoomNo(),
		            		command.getCheckInTime(),
		            		command.getCheckOutTime(),
		            		command.getAccountNo()
		            )
		    );
	  }
	  
	  @EventSourcingHandler
	  public void on(HotelReservationEvent event) {
		  this.reservationId=event.getReservationId();
	      this.hotelName = event.getHotelName();
	      this.hotelId = event.getHotelId();
	      this.roomNo=event.getRoomNo();
	      this.checkInTime=event.getCheckInTime();
	      this.checkOutTime=event.getCheckOutTime();
	      this.guestId=event.getGuestId();
	      this.guestMobileNo=event.getGuestMobileNo();
	      this.guestName=event.getGuestName();
	      this.accountNo=event.getAccountNo();     
	  }
}
