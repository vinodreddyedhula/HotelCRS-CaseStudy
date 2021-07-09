package com.crs.cqrs.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNotificationCommand {

	@TargetAggregateIdentifier
	public String notificationId;
	public String notificationType;
	public String message;

	
}
