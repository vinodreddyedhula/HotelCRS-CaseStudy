package com.crs.domain.guest.entity;

import java.io.Serializable;

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
@Entity(name="ADDRESS")
public class Address implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 8218599147252203424L;

	@Id
	@Column(name="ID")
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	private String id;
	
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
