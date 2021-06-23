package com.crs.app.hotel.dto;

public class ErrorResponse extends BaseRestApiResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1489579888012706615L;
	private ErrorDetails error;
	
	public ErrorResponse() {
		super("Operation Failed",false);
	}

	public ErrorResponse(ErrorDetails error) {
		super("Operation Failed",false);
		this.error=error;
	}
}
