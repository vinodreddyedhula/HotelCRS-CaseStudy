package com.crs.notification.rest.controller;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crs.notification.cqrs.service.NotificationCommandService;
import com.crs.notification.dto.NotificationRequest;

@RestController
@RequestMapping(value = "/api/v1/", produces = "application/json")
public class NotificationController {

	@Autowired
	private NotificationCommandService notificationCommandService;

	@PostMapping("cqrs/notification")
	public CompletableFuture<NotificationRequest> sendNotification(
			@Valid @RequestBody NotificationRequest notificationDTO) {

		return notificationCommandService
				.sendNotification(notificationDTO);

	}
}
