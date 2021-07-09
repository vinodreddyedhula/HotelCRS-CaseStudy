package com.crs.payment.cqrs.aggregate;

import java.math.BigDecimal;
import java.util.Date;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.crs.cqrs.commands.CreatePaymentCommand;
import com.crs.cqrs.events.PaymentCreationEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Aggregate
public class PaymentAggregate {

	@AggregateIdentifier
	private String paymentId;
	private String reservationId;
	private Long accountNo;
	private BigDecimal amount;
	private Date paymentTime;
	private String paymentStatus;

	@CommandHandler
	public PaymentAggregate(CreatePaymentCommand createPaymentCommand) {
		AggregateLifecycle.apply(new PaymentCreationEvent(createPaymentCommand.getPaymentId(),
				createPaymentCommand.getReservationId(), createPaymentCommand.getAccountNo(),
				createPaymentCommand.getAmount(), createPaymentCommand.getPaymentTime()));
	}
	
	 @EventSourcingHandler
	    protected void on(PaymentCreationEvent createPaymentCommand){
	        this.paymentId = createPaymentCommand.getPaymentId();
	        this.reservationId = createPaymentCommand.getReservationId();
	        this.paymentStatus = "PAID";
	        this.amount=createPaymentCommand.getAmount();
	        this.accountNo=createPaymentCommand.getAccountNo();
	    }

}
