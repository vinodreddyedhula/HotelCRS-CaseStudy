package com.crs.notification.cqrs.service;

import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.crs.cqrs.commands.CreateNotificationCommand;
import com.crs.notification.dto.NotificationRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationCommandService {
	
	  private final CommandGateway commandGateway;

	    public CompletableFuture<NotificationRequest> sendNotification(NotificationRequest notificationDTO) {
	        return this.commandGateway.send(new CreateNotificationCommand(
	        		notificationDTO.getNotificationId(),
	        		notificationDTO.getNotificationType(),
	        		notificationDTO.getMessage()
	        ));
	    }

}
