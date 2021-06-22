package com.crs.app.guest.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuestDTO {

	private String id;
	@NotNull
	private String name;
	private String mobileNumber;
	private String emailId;
	private String documentType;
	private String documentId;
	private AddressDTO address;
	private String status;
	
}
