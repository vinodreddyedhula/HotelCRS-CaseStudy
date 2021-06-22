package com.crs.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<?> handleGlobalExceptions(BaseException exception) {

		if (exception instanceof BusinessException) {
			BusinessException res = (BusinessException) exception;
			return new ResponseEntity<BusinessException>(res, HttpStatus.UNPROCESSABLE_ENTITY);
		} /*
			 * else if (exception instanceof ValidationException) { ValidationException res
			 * = (ValidationException) exception; return new
			 * ResponseEntity<ValidationException>(res, HttpStatus.NOT_FOUND); } else {
			 * return new ResponseEntity<>
			 * ("Oops..Some problem in processing your request.Please try after some time.",
			 * HttpStatus.INTERNAL_SERVER_ERROR); }
			 */
		return null;

	}

}
