package com.crs.domain.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crs.domain.guest.entity.Guest;

@Repository("guestRepository")
public interface GuestRepository extends JpaRepository<Guest, String>{

}
