package com.crs.domain.hotel.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.crs.domain.hotel.entities.Hotel;
import com.crs.domain.hotel.repository.IHotelRepository;
import com.crs.hotel.exception.BusinessException;

@Service("hotelDomainService")
public class HotelDomainService {
	
	@Autowired
	@Qualifier("hotelrepository")
	private IHotelRepository repository;
	
	public void addHotelDetails(Hotel hotelDetails) {
		hotelDetails.setCreatedDate(new Date());
		hotelDetails.setModifiedDate(new Date());
		repository.save(hotelDetails);
	}
	
	public void updateHotelDetails(Hotel hotelDetails) {
		hotelDetails.setModifiedDate(new Date());
		repository.save(hotelDetails);
	}
	
	public Hotel fetchHotelDetails(String hotelId) {
		Optional<Hotel> hotelDetails=repository.findById(hotelId);
		validateHotelDtls(hotelDetails);
		return hotelDetails.get();
	}

	public void deleteHotelDetails(String hotelId) {
		Optional<Hotel> hotelDetails=repository.findById(hotelId);
		validateHotelDtls(hotelDetails);
		hotelDetails.get().setModifiedDate(new Date());
		repository.delete(hotelDetails.get());
	}
	
	public void validateHotelDtls(Optional<Hotel> hotelDetails) {
		if(!hotelDetails.isPresent()) {
			throw new BusinessException("HOTEL_DTLS_NOT_FOUND","Hotel Details not found in system ");
		}
	}
}
