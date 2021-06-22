package com.crs.apigateway.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HotelServiceRouteLocator {

	@Value("${hotel.baseurl}")
	private String hotelBaseUrl;

	@Bean
	public RouteLocator hotelServiceRoutes(RouteLocatorBuilder builder) {

		return builder.routes().route("hotel", r -> r.path("/api/v1/hotels/**").uri(hotelBaseUrl)).
				build();

	}

}
