package com.crs.common.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HotelReservationResponse implements Serializable{

	
	private static final long serialVersionUID = -7613717364366228778L;
	
	private String reservationId;
	private String hotelId;
	private String hotelName;
	private String guestName;
	private String guestMobileNo;
	private String roomNo;
	private String roomType;
	private BigDecimal roomAmount;
	private Long accountNo;
	private Date checkInTime;
	private Date checkOutTime;	
	

}
