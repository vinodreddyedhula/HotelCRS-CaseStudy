package com.crs.app.hotel.interfaces;

import com.crs.app.hotel.dto.HotelDTO;
import com.crs.app.hotel.dto.HotelResponseDTO;

public interface HotelApplicationService {
	
	public HotelResponseDTO addHotel(HotelDTO hotelDTO);
	public HotelResponseDTO updateHotel(HotelDTO hotelDTO,String hotelId);
	public HotelResponseDTO fetchHotelDtls(String hotelId);
    public HotelResponseDTO deleteHotelDetails(String hotelId);

}
