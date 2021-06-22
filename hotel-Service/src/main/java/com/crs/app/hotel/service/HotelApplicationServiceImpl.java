package com.crs.app.hotel.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.crs.app.hotel.assembler.ModelMapperConverter;
import com.crs.app.hotel.dto.HotelDTO;
import com.crs.app.hotel.dto.HotelResponseDTO;
import com.crs.app.hotel.interfaces.HotelApplicationService;
import com.crs.domain.hotel.entities.Hotel;
import com.crs.domain.hotel.service.HotelDomainService;

import lombok.extern.slf4j.Slf4j;

@Service("hotelApplicationService")
@Slf4j
@Transactional
public class HotelApplicationServiceImpl implements HotelApplicationService{

	@Autowired
	@Qualifier("hotelDomainService")
	private HotelDomainService hotelDomainService;
	
	/**
	 * This method is used to add the Hotel Details according to Region/Country and
	 * respective room details and its status.
	 */
	
	@Override
	public HotelResponseDTO addHotel(HotelDTO hotelDTO) {
		log.info("Add Hotel Details");
		ModelMapperConverter hotelAssembler=new ModelMapperConverter();
		Hotel hotelDetails=hotelAssembler.toDomainObject(hotelDTO);
		hotelDomainService.addHotelDetails(hotelDetails);
		HotelResponseDTO responseDTO=hotelAssembler.fromDomainObject(hotelDetails);
		return responseDTO;
	}

	/**
	 * This method is used to update the Hotel Details according to Region/Country and
	 * respective room details and its status.
	 */
	
	@Override
	public HotelResponseDTO updateHotel(HotelDTO hotelDTO,String hotelId) {
		// TODO Auto-generated method stub
		log.info("Update Hotel Details");
		ModelMapperConverter hotelAssembler=new ModelMapperConverter();
		Hotel hotelDetails=hotelAssembler.toDomainObject(hotelDTO);
		hotelDetails.setKey(hotelId);
		hotelDomainService.updateHotelDetails(hotelDetails);
		HotelResponseDTO responseDTO=hotelAssembler.fromDomainObject(hotelDetails);
		return responseDTO;
	}

	/**
	 * This method is used to fetch the Hotel Details and
	 * respective room details.
	 */
	
	@Override
	public HotelResponseDTO fetchHotelDtls(String hotelId) {
		// TODO Auto-generated method stub
		log.info("Fetch Hotel Details");
		ModelMapperConverter hotelAssembler=new ModelMapperConverter();
		HotelResponseDTO responseDTO=null;
		Hotel hotelDetails=hotelDomainService.fetchHotelDetails(hotelId);
		responseDTO=hotelAssembler.fromDomainObject(hotelDetails);
		return responseDTO;

	}

	/**
	 * This method is used to delete the Hotel Details based on the given 
	 * hotel-id.
	 */
	@Override
	public HotelResponseDTO deleteHotelDetails(String hotelId) {
		HotelResponseDTO response=new HotelResponseDTO();
		log.info("Delete Hotel Details");
		hotelDomainService.deleteHotelDetails(hotelId);
		response.setMessage("Hotel Details Deleted Successfully");
		return response;
	}

}
