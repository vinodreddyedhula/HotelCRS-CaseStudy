package com.crs.app.hotel.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponse implements Serializable{
	
	private String message;
	private String statusCode;
	

}
