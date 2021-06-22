package com.crs.reservation.exception;

public class ValidationException extends BaseException{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 3365813114846523459L;

	public ValidationException(String errorCode,String errorMessages) {
	    	
	    	super(errorCode,errorMessages);
	    }

}
