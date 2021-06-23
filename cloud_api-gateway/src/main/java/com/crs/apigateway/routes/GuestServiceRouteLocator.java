package com.crs.apigateway.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GuestServiceRouteLocator {

	@Value("${guest.baseUrl}")
	private String guestBaseUrl;

	@Bean
	public RouteLocator accountingRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("guest", r -> r.path("/api/v1/guest/**")
						.uri(guestBaseUrl))
				.build();
	}
}
