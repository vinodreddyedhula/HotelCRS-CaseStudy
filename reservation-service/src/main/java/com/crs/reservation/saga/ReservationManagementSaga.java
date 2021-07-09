package com.crs.reservation.saga;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

import com.crs.cqrs.commands.CreateNotificationCommand;
import com.crs.cqrs.commands.CreatePaymentCommand;
import com.crs.cqrs.events.NotificationCreationEvent;
import com.crs.cqrs.events.PaymentCreationEvent;
import com.crs.reservation.cqrs.events.HotelReservationEvent;

import lombok.extern.slf4j.Slf4j;

@Saga
@Slf4j
public class ReservationManagementSaga {

	@Inject
	private transient CommandGateway commandGateway;

	@StartSaga
	@SagaEventHandler(associationProperty = "reservationId")
	public void handle(HotelReservationEvent reservationEvent) {
		String paymentId = UUID.randomUUID().toString();
		log.info("Saga invoked");

		// associate Saga
		SagaLifecycle.associateWith("paymentId", paymentId);

		log.info("reservation id" + reservationEvent.getReservationId());

		// send the commands
		commandGateway.send(new CreatePaymentCommand(paymentId, reservationEvent.getReservationId().toString(),
				reservationEvent.getAccountNo(), BigDecimal.ONE, new Date()));

	}

	@SagaEventHandler(associationProperty = "paymentId")
	public void handle(PaymentCreationEvent paymentCreationEvent) {

		String notificationId = UUID.randomUUID().toString();
		log.info("Saga continued for create notification command");

		// associate Saga
		SagaLifecycle.associateWith("notificationId", notificationId);
		String message = "Reservation done successfully";
		// send the commands
		commandGateway.send(new CreateNotificationCommand(notificationId, "9059982249", message));

	}

	@SagaEventHandler(associationProperty = "notificationId")
	public void handle(NotificationCreationEvent notificationCreationEvent) {

		log.info("Saga ended");

		SagaLifecycle.end();

	}
}
