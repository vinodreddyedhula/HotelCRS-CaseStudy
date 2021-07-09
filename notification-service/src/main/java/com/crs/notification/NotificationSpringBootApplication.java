package com.crs.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NotificationSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationSpringBootApplication.class, args);
	}

}
