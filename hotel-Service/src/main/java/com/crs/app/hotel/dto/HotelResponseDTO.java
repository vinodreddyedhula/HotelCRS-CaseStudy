package com.crs.app.hotel.dto;

import java.util.Date;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@NoArgsConstructor
@Getter
@Setter
public class HotelResponseDTO extends BaseResponse {


	private static final long serialVersionUID = -876916994830663201L;
	private String key;
	private String hotelName;
	private String region;
	private String timings;
	private AddressDTO address;
	private String status;
	private Set<RoomDTO> roomsInfo;
	private Date createdDate;
	private Date modifiedDate;

}
