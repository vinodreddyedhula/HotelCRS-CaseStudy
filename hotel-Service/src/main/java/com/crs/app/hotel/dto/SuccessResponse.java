package com.crs.app.hotel.dto;

public class SuccessResponse<T> extends BaseRestApiResponse{


	private static final long serialVersionUID = -8078666400420681642L;
	
	private T response;
	
	public SuccessResponse(T response) {
		super();
		this.response=response;
	}
	public SuccessResponse(String message,T response) {
		super(message,true);
		this.response=response;
	}

	public Object getResponse() {
		return response;
	}
}
