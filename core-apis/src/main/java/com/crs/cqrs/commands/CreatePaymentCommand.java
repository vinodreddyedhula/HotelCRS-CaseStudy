package com.crs.cqrs.commands;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data               
@NoArgsConstructor  
@AllArgsConstructor
public class CreatePaymentCommand {
	
	  @TargetAggregateIdentifier
	  private String paymentId;
	  private String reservationId;
	  private Long accountNo;
	  private BigDecimal amount;
	  private Date paymentTime;
	 

}
