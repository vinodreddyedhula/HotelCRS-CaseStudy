package com.crs.common.app.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HotelReservationDTO implements Serializable {

	private static final long serialVersionUID = 5411750681277571489L;
	
	@ApiModelProperty(hidden=true)
	private String reservationId;
	private String guestId;
	private String hotelId;
	private String hotelName;
	private String guestName;
	private String guestMobileNo;
	private String roomNo;
	private Long accountNo;
	private Date checkInTime;
	private Date checkOutTime;
	

}
