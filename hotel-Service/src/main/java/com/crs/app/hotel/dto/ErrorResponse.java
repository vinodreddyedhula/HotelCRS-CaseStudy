package com.crs.app.hotel.dto;

public class ErrorResponse extends BaseRestApiResponse{
	
	private ErrorDetails error;
	
	public ErrorResponse() {
		super("Operation Failed",false);
	}

	public ErrorResponse(ErrorDetails error) {
		super("Operation Failed",false);
		this.error=error;
	}
}
