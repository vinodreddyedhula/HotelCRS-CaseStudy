package com.crs.app.guest.interfaces;

import com.crs.app.guest.dto.GuestDTO;

public interface GuestApplicationService {
	
	public GuestDTO add(GuestDTO guestDTO);
	public GuestDTO update(String id, GuestDTO guestDTO);
	public GuestDTO fetch(String id);
	public GuestDTO delete(String id);
}
