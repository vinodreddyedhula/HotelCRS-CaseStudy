package com.crs.reservation.app.dto;

public class ErrorResponse extends BaseRestApiResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -161438982202579045L;
	private ErrorDetails error;
	
	public ErrorResponse() {
		super("Operation Failed",false);
	}

	public ErrorResponse(ErrorDetails error) {
		super("Operation Failed",false);
		this.error=error;
	}
}
