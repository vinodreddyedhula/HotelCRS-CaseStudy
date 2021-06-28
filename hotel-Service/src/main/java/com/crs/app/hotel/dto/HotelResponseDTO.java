package com.crs.app.hotel.dto;

import java.util.Date;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;
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
	@ApiModelProperty(hidden=true)
	private Date createdDate;
	@ApiModelProperty(hidden=true)
	private Date modifiedDate;
	@Override
	public String toString() {
		return "HotelResponseDTO [key=" + key + ", hotelName=" + hotelName + ", region=" + region + ", timings="
				+ timings + ", address=" + address + ", status=" + status + ", roomsInfo=" + roomsInfo
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}

}
