package com.crs.app.hotel.interfaces;

import org.springframework.http.ResponseEntity;

import com.crs.app.hotel.dto.ErrorResponse;
import com.crs.app.hotel.dto.HotelAPIResponse;
import com.crs.app.hotel.dto.HotelDTO;
import com.crs.app.hotel.dto.HotelResponseDTO;
import com.crs.app.hotel.dto.SuccessResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface HotelController {
	
	 @ApiOperation(value="Add Hotel Details")
	 @ApiResponses(value= {
			 @ApiResponse(code=200,message="Successfully Created",response=HotelAPIResponse.class),
			 @ApiResponse(code=400,message="Invalid Request",response=ErrorResponse.class),
			 @ApiResponse(code=401,message="You are not authorized to view the resource",response=ErrorResponse.class),
			 @ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden",response=ErrorResponse.class),
			 @ApiResponse(code=404,message="The resource you were trying to reach is not found",response=ErrorResponse.class),
			 @ApiResponse(code=500,message="Internal validation error",response=ErrorResponse.class)
	 })
	public ResponseEntity<SuccessResponse<HotelResponseDTO>> addHotel(HotelDTO hotelDTO);
	 
	 @ApiOperation(value="Update Hotel Details")
	 @ApiResponses(value= {
			 @ApiResponse(code=200,message="Successfully Updated",response=HotelAPIResponse.class),
			 @ApiResponse(code=400,message="Invalid Request",response=ErrorResponse.class),
			 @ApiResponse(code=401,message="You are not authorized to view the resource",response=ErrorResponse.class),
			 @ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden",response=ErrorResponse.class),
			 @ApiResponse(code=404,message="The resource you were trying to reach is not found",response=ErrorResponse.class),
			 @ApiResponse(code=500,message="Internal validation error",response=ErrorResponse.class)
	 })
	public ResponseEntity<SuccessResponse<HotelResponseDTO>> updateHotel(HotelDTO hotelDTO,String hotelId);
	 
	 
	 @ApiOperation(value="Fetch Hotel Details")
	 @ApiResponses(value= {
			 @ApiResponse(code=200,message="Successfully Updated",response=HotelAPIResponse.class),
			 @ApiResponse(code=400,message="Invalid Request",response=ErrorResponse.class),
			 @ApiResponse(code=401,message="You are not authorized to view the resource",response=ErrorResponse.class),
			 @ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden",response=ErrorResponse.class),
			 @ApiResponse(code=404,message="The resource you were trying to reach is not found",response=ErrorResponse.class),
			 @ApiResponse(code=500,message="Internal validation error",response=ErrorResponse.class)
	 })
	public ResponseEntity<SuccessResponse<HotelResponseDTO>> getHotelDetails(String hotelId);
	 
	 @ApiOperation(value="Delete Hotel Details")
	 @ApiResponses(value= {
			 @ApiResponse(code=200,message="Successfully Deleted",response=HotelAPIResponse.class),
			 @ApiResponse(code=400,message="Invalid Request",response=ErrorResponse.class),
			 @ApiResponse(code=401,message="You are not authorized to view the resource",response=ErrorResponse.class),
			 @ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden",response=ErrorResponse.class),
			 @ApiResponse(code=404,message="The resource you were trying to reach is not found",response=ErrorResponse.class),
			 @ApiResponse(code=500,message="Internal validation error",response=ErrorResponse.class)
	 })
	public ResponseEntity<SuccessResponse<HotelResponseDTO>> deleteHotelDetails(String hotelId);


}
