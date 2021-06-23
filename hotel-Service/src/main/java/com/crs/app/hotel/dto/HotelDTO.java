package com.crs.app.hotel.dto;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
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
	
	  @ApiModelProperty(hidden=true)
	  private String key;
      
      @NotEmpty(message="Hotel Name cannot be empty")	
	  private String hotelName;
      
      @NotEmpty(message="Region cannot be empty")	
	  private String region;
      
      @NotEmpty(message="Timings cannot be empty")	
	  private String timings;
      
	  private AddressDTO address;
      
      @NotEmpty(message="Status cannot be empty")	
	  private String status;
      
      @NotNull(message="")	
	  private Set<RoomDTO> roomsInfo;


}
