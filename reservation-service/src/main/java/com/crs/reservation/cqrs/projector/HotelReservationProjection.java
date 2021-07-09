package com.crs.reservation.cqrs.projector;

import java.math.BigDecimal;
import java.util.Date;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.crs.reservation.app.dto.HotelReservationResponse;
import com.crs.reservation.app.mapper.ModelMapperConverter;
import com.crs.reservation.app.service.PaymentHelperService;
import com.crs.reservation.cqrs.command.GetReservationDetailsQuery;
import com.crs.reservation.cqrs.events.HotelReservationEvent;
import com.crs.reservation.domain.entities.HotelReservationDetails;
import com.crs.reservation.domain.repository.HotelReservationRepository;
import com.crs.reservation.feignclient.GlobalFeignClientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class HotelReservationProjection {

	@Autowired
	private HotelReservationRepository reservationRepository;

	@Autowired
	@Qualifier("paymentHelperService")
	private PaymentHelperService paymentService;

	@Autowired
	@Qualifier("globalFeignClientService")
	private GlobalFeignClientService feignClientService;

	@EventHandler
	public HotelReservationResponse on(HotelReservationEvent event) {
		log.debug("Handling a hotel reservation command {}", event.getReservationId());
	
		ModelMapperConverter mapper = new ModelMapperConverter();
		reservationRepository.save(prepareReservationDTO(event));
		return mapper.fromDomainObject(prepareReservationDTO(event));
		
	}

	private HotelReservationDetails prepareReservationDTO(HotelReservationEvent event) {

		HotelReservationDetails bankAccount = new HotelReservationDetails(event.getReservationId().toString(),
				event.getHotelId(), event.getHotelName(), event.getGuestId(), event.getGuestMobileNo(),
				event.getGuestName(), event.getRoomNo(), null, BigDecimal.ONE, event.getCheckInTime(),
				event.getCheckOutTime(), event.getAccountNo(), true, "Booked", new Date(), new Date());

		return bankAccount;
	}
	
	@QueryHandler
	public HotelReservationResponse handle(GetReservationDetailsQuery query) {
	    log.debug("Handling Get Reservation Details Query: {}", query);
	    return new ModelMapperConverter().fromDomainObject( reservationRepository.getById(query.getReservationId().toString()));
	    
	}

}
