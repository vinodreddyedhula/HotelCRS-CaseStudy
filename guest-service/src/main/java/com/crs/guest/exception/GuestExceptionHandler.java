package com.crs.guest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GuestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalExceptions(Exception exception) {

		if (exception instanceof BusinessException) {
			return new ResponseEntity<>((BusinessException) exception, HttpStatus.UNPROCESSABLE_ENTITY);
		} else if (exception instanceof ValidationException) {
			return new ResponseEntity<>((ValidationException) exception, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Oops..Some problem in processing your request.Please try after some time.",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
