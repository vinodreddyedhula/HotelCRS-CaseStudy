package com.crs.domain.guest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.crs.domain.guest.entity.Guest;
import com.crs.domain.guest.repository.GuestRepository;
import com.crs.guest.exception.BusinessException;
import com.crs.guest.exception.ValidationException;

@Service("guestDomainService")
public class GuestDomainService {

	@Autowired
	@Qualifier("guestRepository")
	private GuestRepository repository;

	public Guest add(Guest guest) {
		guest.setStatus("Active");
		return repository.save(guest);
	}

	public Guest update(Guest guest) {
		repository.save(guest);
		return guest;
	}

	public Guest fetch(String id) {
		validateGuestId(id);
		Optional<Guest> guest = repository.findById(id);
		validateGuest(guest);
		return guest.get();
	}
	
	public Guest delete(String id) {
		Optional<Guest> guest = repository.findById(id);
		validateGuest(guest);
		repository.delete(guest.get());
		return guest.get();
	}
	
	private void validateGuest(Optional<Guest> guest) {
		if(!guest.isPresent()) {
			throw new BusinessException("GUEST_DTLS_NOT_FOUND","Guest Details not found in system ");
		}
	}
	
	private void validateGuestId(String id) {
		if(StringUtils.isEmpty(id)) {
			throw new ValidationException("GUEST_ID_NOT_FOUND","Guest Id Cannot be Empty");
		}
	}

}
