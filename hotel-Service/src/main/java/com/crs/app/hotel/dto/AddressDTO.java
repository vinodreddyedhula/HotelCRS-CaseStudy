package com.crs.app.hotel.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO implements Serializable{
	
	
	private static final long serialVersionUID = 5381183414577788126L;

	@NotEmpty(message="City cannot be empty")	
	private String city;
	
	@NotEmpty(message="State cannot be empty")	
	private String state;
	
	@NotEmpty(message="District cannot be empty")	
	private String district;
	
	private String addressLine1;
	private String addressLine2;
	
	@NotEmpty(message="Pincode cannot be empty")	
	private String pinCode;



}
