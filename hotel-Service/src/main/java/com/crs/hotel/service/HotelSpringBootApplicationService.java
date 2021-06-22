package com.crs.hotel.service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.crs.*"})
@EnableSwagger2
@EnableJpaRepositories("com.crs.domain.hotel.repository")
@EntityScan("com.crs.domain.hotel.entities")
@EnableEurekaClient
public class HotelSpringBootApplicationService {
	
	public static void main(String[] args) {
		SpringApplication.run(HotelSpringBootApplicationService.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
}
 