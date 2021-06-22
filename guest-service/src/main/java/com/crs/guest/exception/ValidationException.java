package com.crs.guest.exception;

public class ValidationException extends BaseException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2722323671493521423L;

	public ValidationException(String errorCode,String errorMessages) {
		super(errorCode,errorMessages);
	}

	public ValidationException(String message) {
		super(message);
	}


	

}
