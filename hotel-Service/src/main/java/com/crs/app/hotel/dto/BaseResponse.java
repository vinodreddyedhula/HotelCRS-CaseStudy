package com.crs.app.hotel.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4406281190325177940L;
	private String message;
	private String statusCode;
	

}
