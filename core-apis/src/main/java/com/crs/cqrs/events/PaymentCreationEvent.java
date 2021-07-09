package com.crs.cqrs.events;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentCreationEvent {
	
	  private String paymentId;
	  private String reservationId;
	  private Long accountNo;
	  private BigDecimal amount;
	  private Date paymentTime;

}
