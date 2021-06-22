package com.crs.app.hotel.enums;

public enum RoomType {
	
	NORMAL("Normal"),LUXURY("Luxury");
	
	private final String value;
	
	RoomType(String value){
		this.value=value;
	}
	
	/*
	 * public static RoomType getEnum(String value) { if(value==null ||
	 * "".equals(value)) { return null; } for(RoomType status:values())
	 * if(status.toString().equalsIgnoreCase(value)) return status; throw new
	 * IllegalArgumentException();
	 * 
	 * }
	 */

}
