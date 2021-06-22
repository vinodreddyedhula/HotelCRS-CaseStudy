package com.crs.reservation.app.dto;

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
