package com.crs.reservation.app.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.crs.reservation.app.dto.GuestDTO;
import com.crs.reservation.app.dto.HotelReservationDTO;
import com.crs.reservation.app.dto.HotelReservationResponse;
import com.crs.reservation.app.dto.HotelResponseDTO;
import com.crs.reservation.app.dto.PaymentDTO;
import com.crs.reservation.app.dto.RoomsDTO;
import com.crs.reservation.app.interfaces.ReservationAppService;
import com.crs.reservation.app.mapper.ModelMapperConverter;
import com.crs.reservation.domain.entities.HotelReservationDetails;
import com.crs.reservation.domain.repository.HotelReservationRepository;
import com.crs.reservation.feignclient.GlobalFeignClientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReservationAppServiceImpl implements ReservationAppService {

	@Autowired
	private HotelReservationRepository reservationRepository;

	@Autowired
	@Qualifier("paymentHelperService")
	private PaymentHelperService paymentService;

	@Autowired
	@Qualifier("globalFeignClientService")
	private GlobalFeignClientService feignClientService;

	@Override
	public HotelReservationResponse doReservation(HotelReservationDTO reservationDTO) {
		ModelMapperConverter mapper = new ModelMapperConverter();
		HotelResponseDTO hotelDetails = feignClientService.getHotelDetails(reservationDTO.getHotelId());
		GuestDTO guestDetails = feignClientService.getGuestDetails(reservationDTO.getGuestId());
		if (guestDetails != null && hotelDetails != null && hotelDetails.getRoomsInfo().size()>0) {
			RoomsDTO roomInfo = hotelDetails.getRoomsInfo().stream()
					.filter(x -> x.getRoomNo().equals(reservationDTO.getRoomNo())).findAny().orElse(null);
			HotelReservationDetails reservationDetails = mapper.toDomainObject(reservationDTO);
			boolean isPaymentDone = paymentService.doPayment(preparePaymentDTO(reservationDTO, roomInfo));
			if (isPaymentDone) {
				reservationDetails.setReservationDate(new Date());
				reservationDetails.setModifiedDate(new Date());
				reservationRepository.save(reservationDetails);
				return mapper.fromDomainObject(reservationDetails);
			}
		}
		return null;
	}

	private PaymentDTO preparePaymentDTO(HotelReservationDTO reservationDTO, RoomsDTO roomInfo) {
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setAccountNo(reservationDTO.getAccountNo());
		paymentDTO.setMobileNo(reservationDTO.getGuestMobileNo());
		paymentDTO.setAmount(roomInfo!=null?roomInfo.getRoomPrice():BigDecimal.ONE);
		paymentDTO.setReservationId(UUID.randomUUID().toString());
		return paymentDTO;
	}

	@Override
	public HotelReservationResponse getReservationDetails(String reservationId) {
		log.info("Fetch Reservation Details");
		return new ModelMapperConverter().fromDomainObject(reservationRepository.getById(reservationId));
	}
}
