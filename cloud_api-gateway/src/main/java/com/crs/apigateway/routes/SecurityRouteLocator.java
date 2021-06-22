package com.crs.apigateway.routes;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.crs.apigateway.security.handler.AuthHandler;

@Configuration
public class SecurityRouteLocator {
	
    @Autowired
    private AuthHandler authHandler;

    @Bean
    public RouterFunction<ServerResponse> authRoute() {
        return RouterFunctions
                .route(POST("/auth/login").and(accept(APPLICATION_JSON)), authHandler::login);
    }
}
