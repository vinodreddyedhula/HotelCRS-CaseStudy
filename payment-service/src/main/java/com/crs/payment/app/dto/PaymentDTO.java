package com.crs.payment.app.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PaymentDTO {
	
	private String paymentId;
	private String reservationId;
	private BigDecimal amount;
	private Date paymentDate;
	private long accountNo;

}
