package com.crs.app.hotel.dto;


public class HotelAPIResponse extends SuccessResponse<HotelResponseDTO>{
	
	private static final long serialVersionUID = 8661098531049302652L;

	public HotelAPIResponse(HotelResponseDTO response) {
		super(response);
	}

	@Override
	public HotelResponseDTO getResponse() {
		return (HotelResponseDTO) super.getResponse();
	}

}
