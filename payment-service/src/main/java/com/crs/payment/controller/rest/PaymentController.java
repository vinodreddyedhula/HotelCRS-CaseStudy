package com.crs.payment.controller.rest;

import java.util.concurrent.CompletableFuture;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crs.payment.app.dto.PaymentDTO;
import com.crs.payment.cqrs.service.PaymentCommandService;

@RestController
@RequestMapping(value = "/api/v1/", produces = "application/json")
public class PaymentController {

	@Autowired
	private PaymentCommandService paymentCommandService;

	@PostMapping("cqrs/payment")
	public CompletableFuture<PaymentDTO> doPayment(@Valid @RequestBody PaymentDTO paymentDTO) {

		CompletableFuture<PaymentDTO> paymentResponse = paymentCommandService.createReservation(paymentDTO);
		return paymentResponse;
	}

}
