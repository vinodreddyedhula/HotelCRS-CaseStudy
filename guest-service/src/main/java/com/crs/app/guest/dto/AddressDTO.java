package com.crs.app.guest.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1719110529168512087L;
	
	private String id;
	public String city;
	public String state;
	public String district;
	public String addressLine1;
	public String addressLine2;
	public String pinCode;



}
