package com.crs.apigateway.security.handler;

import static org.springframework.http.MediaType.APPLICATION_JSON;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.crs.apigateway.security.dto.ApiResponse;
import com.crs.apigateway.security.dto.LoginRequest;
import com.crs.apigateway.security.dto.LoginResponse;
import com.crs.apigateway.security.dto.Role;
import com.crs.apigateway.security.dto.User;

import reactor.core.publisher.Mono;

@Component
public class AuthHandler {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private TokenProvider tokenProvider;
	
	public static final String userName = "user";
	public static final String password = "user123";

	public AuthHandler(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public Mono<ServerResponse> login(ServerRequest request) {
		Mono<LoginRequest> loginRequest = request.bodyToMono(LoginRequest.class);
		return loginRequest.flatMap(login -> {
			User user = prepareDefaultUserDetails();
			if (userName.equalsIgnoreCase(login.getUsername())) {
				if (passwordEncoder.matches(login.getPassword(), user.getPassword())) {
					return ServerResponse.ok().contentType(APPLICATION_JSON)
							.body(BodyInserters.fromObject(new LoginResponse(tokenProvider.generateToken(user))));
				} else {
					return ServerResponse.badRequest()
							.body(BodyInserters.fromObject(new ApiResponse(400, "Invalid credentials", null)));
				}
			} else {
				return ServerResponse.badRequest()
						.body(BodyInserters.fromObject(new ApiResponse(400, "User not found", null)));
			}

		});
	}

	public User prepareDefaultUserDetails() {
		User user = new User();
		user.setUsername(userName);
		user.setPassword(passwordEncoder.encode(password));
		List<Role> roles = new ArrayList<Role>();
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		role.setName("ADMIN");
		roles.add(role);
		user.setRoles(roles);
		return user;
	}
}
