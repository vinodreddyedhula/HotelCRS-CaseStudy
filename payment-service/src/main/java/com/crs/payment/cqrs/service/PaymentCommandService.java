package com.crs.payment.cqrs.service;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.crs.cqrs.commands.CreatePaymentCommand;
import com.crs.payment.app.dto.PaymentDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentCommandService {
	
    private final CommandGateway commandGateway;

    public CompletableFuture<PaymentDTO> createReservation(PaymentDTO paymentDTO) {
        return this.commandGateway.send(new CreatePaymentCommand(
        		paymentDTO.getPaymentId(),
        		paymentDTO.getReservationId(),
        		paymentDTO.getAccountNo(),
        		paymentDTO.getAmount(),
        		new Date()
        ));
    }
	

}
