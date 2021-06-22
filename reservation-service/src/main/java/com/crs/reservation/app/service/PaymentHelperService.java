package com.crs.reservation.app.service;

import org.springframework.stereotype.Service;

import com.crs.reservation.app.dto.PaymentDTO;
import com.crs.reservation.exception.ValidationException;

@Service("paymentHelperService")
public class PaymentHelperService {

	public boolean doPayment(PaymentDTO paymentDTO) {
      	if(paymentDTO!=null) {
      		validatePaymentDTO(paymentDTO);
      	}
      	return true;
	}

	private void validatePaymentDTO(PaymentDTO paymentDTO) {
        if(paymentDTO.getAccountNo()==null) {
        	throw new  ValidationException("ACCOUNT_NO_NULL","Account Number cannot be null or empty");
        }else if(paymentDTO.getAmount()==null) {
        	throw new  ValidationException("AMOUNT_NULL","Amount  cannot be null or empty");
        }else if(paymentDTO.getMobileNo()==null|| paymentDTO.getMobileNo().isEmpty()) {
        	throw new ValidationException("MOBILE_NO_NULL","Mobile Number cannot be null or empty");
        }else if(paymentDTO.getReservationId()==null ||paymentDTO.getReservationId().isEmpty()) {
        	throw  new ValidationException("RESERVATION_ID_NULL","Reservation Id cannot be null or empty");    	
        }
	}
	
}
