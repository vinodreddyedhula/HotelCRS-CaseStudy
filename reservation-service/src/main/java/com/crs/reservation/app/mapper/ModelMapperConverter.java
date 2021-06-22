package com.crs.reservation.app.mapper;

import org.modelmapper.ModelMapper;

import com.crs.reservation.app.dto.HotelReservationDTO;
import com.crs.reservation.app.dto.HotelReservationResponse;
import com.crs.reservation.domain.entities.HotelReservationDetails;

public class ModelMapperConverter {
	
	 private ModelMapper modelMapper;

	    public ModelMapperConverter() {
	        modelMapper = new ModelMapper();
	    }
	    
	    public HotelReservationDetails toDomainObject(HotelReservationDTO hotelDTO) {
	       return modelMapper.map(hotelDTO, HotelReservationDetails.class);
	    }
	   
	    public HotelReservationResponse fromDomainObject(HotelReservationDetails hotelDetails) {
	        return modelMapper.map(hotelDetails, HotelReservationResponse.class);
	    }

}
