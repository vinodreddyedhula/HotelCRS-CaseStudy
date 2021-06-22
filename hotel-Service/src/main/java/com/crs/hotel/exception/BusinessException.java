package com.crs.hotel.exception;

public class BusinessException extends BaseException{
	
	
	/*
	 * public BusinessException(String errorCode) { super(errorCode); }
	 */
	
    public BusinessException(String errorCode,String errorMessages) {
    	
    	super(errorCode,errorMessages);
    }
	
}
