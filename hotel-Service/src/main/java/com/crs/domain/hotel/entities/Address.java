package com.crs.domain.hotel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="EPM_ADDRESS")
public class Address {
    
	@Id
	@Column(name="ADDRESS_ID")
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	private String addressId;

	@Column(name="ID")
	private String ID;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="DISTRICT")
	private String district;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="PINCODE")
	private String pinCode;
	
	@Column(name="ADD_LINE1")
	private String addressLine1;
	
	@Column(name="ADD_LINE2")
	private String addressLine2;
	

}
