package com.crs.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class APIGatewayServer {

	public static void main(String[] args) {
		SpringApplication.run(APIGatewayServer.class, args);
	}

}
