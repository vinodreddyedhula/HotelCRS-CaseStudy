package com.crs.reservation.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity(name="EPM_HOTEL_RESERVATION")
public class HotelReservationDetails implements Serializable{
	
	private static final long serialVersionUID = 1828762333770258928L;

	  @Id
	  @Column(name="RESERVATION_ID")
	  @GeneratedValue(generator="system-uuid")
	  @GenericGenerator(name="system-uuid",strategy="uuid")
	  private String reservationId;
	  
	  @Column(name="HOTEL_NAME")
	  private String hotelName;
	  
	  @Column(name="HOTEL_ID")
	  private String hotelId;
	  
	  @Column(name="GUEST_ID")
	  private String guestId;
	  
	  @Column(name="GUEST_MOBILE_NO")
	  private String guestMobileNo;	
	  
	  @Column(name="GUEST_NAME")
	  private String guestName;
	  
	  @Column(name="ROOM_NO")
	  private String roomNo;
	  
	  @Column(name="ROOM_TYPE")
	  private String roomType;	
	  
	  @Column(name="ROOM_AMOUNT")
	  private BigDecimal roomAmount;  
	  
	  @Column(name="CHECK_IN_TIME")
	  private Date checkInTime;	
	  
	  @Column(name="CHECK_OUT_TIME")
	  private Date checkOutTime;  
	  
	  @Column(name="ACCOUNT_NO")
	  private Long accountNo;
	  
	  @Column(name="IS_AMOUNT_PAID")
	  private boolean isAmountPaid;
	  
	  @Column(name="BOOK_STATUS")
	  private String status;
	  
	  @Column(name="RESERVATION_DATE")
	  private Date reservationDate;

	  @Column(name="MODIFIED_DATE")
	  private Date modifiedDate;

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	  
		
}
