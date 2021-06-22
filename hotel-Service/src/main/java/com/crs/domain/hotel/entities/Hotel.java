package com.crs.domain.hotel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="EPM_HOTEL")
public class Hotel implements Serializable{
	

	private static final long serialVersionUID = 1828762333770258928L;

	  @Id
	  @Column(name="ID")
	  @GeneratedValue(generator="system-uuid")
	  @GenericGenerator(name="system-uuid",strategy="uuid")
	  private String key;
	  
	  @Column(name="NAME")
	  private String hotelName;
	  
	  @Column(name="REGION")
	  private String region;
	  
	  @Column(name="TIMINGS")
	  private String timings;
	  

	  @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	  @JoinColumn(name="ID")
	  private Address address;
	  

	  @OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	  @JoinColumn(name="HOTEL_ID")
	  private Set<Room> roomsInfo;
	  
	  @Column(name="HOTEL_STATUS")
	  private String status;
	  
	  @Column(name="CREATED_DATE")
	  private Date createdDate;

	  @Column(name="MODIFIED_DATE")
	  private Date modifiedDate;

}
