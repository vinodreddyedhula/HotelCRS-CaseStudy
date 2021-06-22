package com.crs.guest.exception;

public class BusinessException extends BaseException{
	
	private static final long serialVersionUID = 8689657681814641131L;

	public BusinessException(String errorCode,String errorMessages) {
    	
    	super(errorCode,errorMessages);
    }
	
}
