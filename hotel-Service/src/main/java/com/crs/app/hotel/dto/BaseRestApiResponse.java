package com.crs.app.hotel.dto;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

@Getter
public class BaseRestApiResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4713646429378010919L;
	
	@ApiModelProperty(hidden=true)
	private String message;
	
	private boolean success=true;
	
	public BaseRestApiResponse() {
		this.message="Operation Completed Successfully";
		this.success=true;
	}
	
	public BaseRestApiResponse(String message,boolean success) {
		super();
		this.message=message;
		this.success=success;
	}

}
