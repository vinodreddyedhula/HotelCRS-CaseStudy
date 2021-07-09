package com.crs.common.app.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponse implements Serializable{
	
	
	private static final long serialVersionUID = 2839844324963431925L;
	private String message;
	private String statusCode;
	

}
