package com.crs.notification.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.crs.notification.dto.NotificationRequest;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotificationConsumer {

	@KafkaListener(topics = "NOTIFICATIONS_TOPIC",groupId = "group_id")
	public void sendNotification(String notificationRequest) {
		NotificationRequest notification = new Gson().fromJson(notificationRequest,
                        NotificationRequest.class);
		log.info("Message Consumed :: "+notification.toString());
	}

}
