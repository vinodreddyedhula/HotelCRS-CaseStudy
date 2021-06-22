package com.crs.hotel.exception;

import lombok.Getter;


@Getter
public class BaseException extends RuntimeException{
	
	private static final long serialVersionUID = -3911639145638209930L;

		// Custom error message
	    private String errorMessage;

	    // Custom error code representing an error in system
	    private String errorCode;

		/*
		 * public BaseException (String message) { super(message); this.errorMessage =
		 * message; }
		 */

	        public BaseException (String message, String errorCode) {
	            super(message);
	            this.errorMessage = message;
	            this.errorCode = errorCode;
	        }
}
