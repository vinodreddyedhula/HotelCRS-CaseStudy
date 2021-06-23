package com.crs.app.hotel.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomDTO {
	
	  @NotEmpty(message="RoomNo cannot be empty")	
	  private String roomNo;
	  
	  @NotEmpty(message="Room Type cannot be empty")
	  private String roomType;
	  
	  @NotEmpty(message="Room Price cannot be empty")
	  private BigDecimal roomPrice;


}
