package com.crs.app.hotel.assembler;

import org.modelmapper.ModelMapper;

import com.crs.app.hotel.dto.HotelDTO;
import com.crs.app.hotel.dto.HotelResponseDTO;
import com.crs.domain.hotel.entities.Hotel;

public class ModelMapperConverter {
	
	 private ModelMapper modelMapper;

	    public ModelMapperConverter() {
	        modelMapper = new ModelMapper();
	    }

	   
	    public Hotel toDomainObject(HotelDTO hotelDTO) {
	       return modelMapper.map(hotelDTO, Hotel.class);
	    }

	   
	    public HotelResponseDTO fromDomainObject(Hotel hotelDetails) {
	        return modelMapper.map(hotelDetails, HotelResponseDTO.class);
	    }

}
