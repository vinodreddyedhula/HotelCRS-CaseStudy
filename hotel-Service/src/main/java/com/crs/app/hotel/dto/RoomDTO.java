package com.crs.app.hotel.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import com.crs.app.hotel.enums.RoomType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomDTO {
	
	  @NotEmpty(message="")	
	  private String roomNo;
	  
	  @NotEmpty(message="")
	  private String roomType;
	  
	  @NotEmpty(message="")
	  private BigDecimal roomPrice;


}
