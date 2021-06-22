package com.crs.domain.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crs.domain.hotel.entities.Hotel;

@Repository("hotelrepository")
public interface IHotelRepository extends JpaRepository<Hotel, String>{
	

}
