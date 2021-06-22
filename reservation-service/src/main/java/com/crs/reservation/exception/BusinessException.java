package com.crs.reservation.exception;

public class BusinessException extends BaseException{
	
	private static final long serialVersionUID = -7397723416961949071L;

	public BusinessException(String errorCode,String errorMessages) {
    	
    	super(errorCode,errorMessages);
    }
	
}
