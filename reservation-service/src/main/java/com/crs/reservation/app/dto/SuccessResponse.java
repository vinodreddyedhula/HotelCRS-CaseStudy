package com.crs.reservation.app.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SuccessResponse<T> extends BaseRestApiResponse {

	private static final long serialVersionUID = -5809921921912089109L;
	private T response;

	public SuccessResponse(T response) {
		super();
		this.response = response;
	}

	public SuccessResponse(String message, T response) {
		super(message, true);
		this.response = response;
	}

	public Object getResponse() {
		return response;
	}

}
