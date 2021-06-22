package com.crs.guest.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableEurekaClient
@EnableJpaRepositories("com.crs.domain.guest.repository")
@EntityScan("com.crs.domain.guest.entity")
@SpringBootApplication(scanBasePackages = {"com.crs.*"})
public class GuestSpringBootApplicationService {
	
	public static void main(String[] args) {
		SpringApplication.run(GuestSpringBootApplicationService.class, args);
	}
	
}
 