package com.crs.app.guest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.crs.app.guest.dto.GuestDTO;
import com.crs.app.guest.interfaces.GuestApplicationService;
import com.crs.app.guest.mapper.GuestMapper;
import com.crs.domain.guest.service.GuestDomainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("guestApplicationServiceImpl")
public class GuestApplicationServiceImpl implements GuestApplicationService {

	@Autowired
	@Qualifier("guestDomainService")
	private GuestDomainService guestDomainService;
	
	@Autowired
    private GuestMapper mapper ;

	@Override
	public GuestDTO add(GuestDTO guestDTO) {
		log.info("Guest Added Successfully");
		return mapper.fromDomainObject(guestDomainService.add(mapper.toDomainObject(guestDTO)));
	}

	@Override
	public GuestDTO update(String id, GuestDTO guestDTO) {
		guestDomainService.update(mapper.toDomainObject(guestDTO));
		return guestDTO;
	}

	@Override
	public GuestDTO fetch(String id) {
		return mapper.fromDomainObject(guestDomainService.fetch(id));
	}

	@Override
	public GuestDTO delete(String id) {
		var guest = guestDomainService.delete(id);
		guest.setStatus("Deleted");
		return mapper.fromDomainObject(guest);
	}
}
