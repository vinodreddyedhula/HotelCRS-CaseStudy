package com.crs.apigateway.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReservationServiceRouteLocator {
	
	@Value("${reservation.baseurl}")
	private String reservationBaseUrl;

	@Bean
	public RouteLocator reservationServiceRoutes(RouteLocatorBuilder builder) {

		return builder.routes().route("reservation", r -> r.path("/api/v1/hotels/**").uri(reservationBaseUrl)).build();

	}

}
