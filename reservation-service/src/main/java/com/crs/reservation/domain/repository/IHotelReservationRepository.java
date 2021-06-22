package com.crs.reservation.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crs.reservation.domain.entities.HotelReservationDetails;

@Repository
public interface IHotelReservationRepository extends JpaRepository<HotelReservationDetails, String>{

}
