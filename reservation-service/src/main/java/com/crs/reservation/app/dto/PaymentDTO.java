package com.crs.reservation.app.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO implements Serializable{

	private static final long serialVersionUID = -8240352560755481648L;
	
	private String mobileNo;
	private BigDecimal amount;
	private Long accountNo;
	private String reservationId;
	
	
}
