package com.crs.domain.hotel.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.crs.app.hotel.enums.RoomType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name="EPM_ROOMS")
public class Room {
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy="uuid")
	@Column(name="ID")
	private String key;
	
	@Column(name="HOTEL_ID")
	private String HotelId;
	
	@Column(name="ROOM_TYPE")
	private String roomType;
	
	@Column(name="ROOM_NO")
	private String roomNo;
	
	@Column(name="ROOM_PRICE")
	private BigDecimal roomPrice;

}
