package com.crs.payment.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PaymentDetails {
	
	  @Id
	  @Column(name="PAYMENT_REF_NO")
	  private String paymentId;
	  
	  @Column(name="RESERVATION_ID")
	  private String reservationId;
	  
	  @Column(name="AMOUNT")
	  private BigDecimal amount;
	  
	  @Column(name="ACCOUNT_NO")
	  private Long accountNo;
	  
	  @Column(name="CREATED_DATE")
	  private Date createdDate;	
	  
	  @Column(name="PAYMENT_STATUS")
	  private String paymentStatus;

}
