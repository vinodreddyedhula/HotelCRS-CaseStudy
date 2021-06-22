package com.crs.app.guest.mapper;

import org.mapstruct.Mapper;

import com.crs.app.guest.dto.GuestDTO;
import com.crs.domain.guest.entity.Guest;

@Mapper(componentModel = "spring")
public interface GuestMapper {

	Guest toDomainObject(GuestDTO dto);

	GuestDTO fromDomainObject(Guest guest);
}
