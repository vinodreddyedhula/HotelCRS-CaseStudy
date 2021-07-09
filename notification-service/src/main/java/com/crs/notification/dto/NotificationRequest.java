package com.crs.notification.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2803219697063227335L;

	private String notificationId;

	private String notificationType;

	private String message;

	@Override
	public String toString() {
		return "NotificationRequest [notificationId=" + notificationId + ", notificationType=" + notificationType
				+ ", message=" + message + "]";
	}
	
	
}
