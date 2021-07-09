package com.crs.payment.cqrs.projection;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crs.cqrs.events.PaymentCreationEvent;
import com.crs.payment.domain.entity.PaymentDetails;
import com.crs.payment.domain.entity.repository.PaymentRepository;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class PaymentServiceProjector {

	@Autowired
	private PaymentRepository repository;

	@EventHandler
	public void on(PaymentCreationEvent event) {
		log.debug("Handling payment creation command {}", event.getPaymentId());
		repository.save(preparePaymentDTO(event));
	}

	private PaymentDetails preparePaymentDTO(PaymentCreationEvent event) {
		return new PaymentDetails(event.getPaymentId(), event.getReservationId(), event.getAmount(),
				event.getAccountNo(), event.getPaymentTime(), "PAID");
	}

}
