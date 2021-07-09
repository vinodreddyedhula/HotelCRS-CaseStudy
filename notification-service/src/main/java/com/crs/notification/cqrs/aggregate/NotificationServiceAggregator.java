package com.crs.notification.cqrs.aggregate;

import java.math.BigDecimal;
import java.util.Date;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import com.crs.cqrs.commands.CreateNotificationCommand;
import com.crs.cqrs.events.NotificationCreationEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class NotificationServiceAggregator {

	@AggregateIdentifier
	private String notificationId;
	private String notificationType;
	private String message;

	@CommandHandler
	public NotificationServiceAggregator(CreateNotificationCommand notificationCommand) {

		AggregateLifecycle.apply(new NotificationCreationEvent(notificationCommand.getNotificationId(),
				notificationCommand.getNotificationType(), notificationCommand.getMessage()));

	}

	@EventSourcingHandler
	protected void on(NotificationCreationEvent notificationEvent) {
		this.notificationId = notificationEvent.getNotificationId();
		this.notificationType = notificationEvent.getNotificationType();
		this.message = notificationEvent.getMessage();
	}

}
