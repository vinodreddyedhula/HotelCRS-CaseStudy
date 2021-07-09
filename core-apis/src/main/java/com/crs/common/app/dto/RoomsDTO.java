package com.crs.common.app.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import com.crs.common.app.enumeration.RoomType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoomsDTO {
	
	  @NotEmpty(message="")	
	  private String roomNo;
	  
	  @NotEmpty(message="")
	  private RoomType roomType;
	  
	  @NotEmpty(message="")
	  private BigDecimal roomPrice;


}
