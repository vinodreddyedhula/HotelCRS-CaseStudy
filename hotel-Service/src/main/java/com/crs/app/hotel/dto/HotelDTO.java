package com.crs.app.hotel.dto;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HotelDTO implements Serializable{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = -7598111445798564995L;
	
      @NotEmpty(message="")	
	  private String key;
      
      @NotEmpty(message="")	
	  private String hotelName;
      
      @NotEmpty(message="")	
	  private String region;
      
      @NotEmpty(message="")	
	  private String timings;
      
      @NotNull(message="")	
	  private AddressDTO address;
      
      @NotEmpty(message="")	
	  private String status;
      
      @NotNull(message="")	
	  private Set<RoomDTO> roomsInfo;


}
