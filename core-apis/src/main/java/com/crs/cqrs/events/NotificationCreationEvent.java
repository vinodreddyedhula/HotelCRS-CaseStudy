package com.crs.cqrs.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationCreationEvent {

	public String notificationId;
	public String notificationType;
	public String message;

}
