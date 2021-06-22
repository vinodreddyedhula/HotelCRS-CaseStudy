package com.crs.reservation.app.interfaces;

import org.springframework.http.ResponseEntity;

import com.crs.reservation.app.dto.ErrorResponse;
import com.crs.reservation.app.dto.HotelReservationDTO;
import com.crs.reservation.app.dto.HotelReservationResponse;
import com.crs.reservation.app.dto.SuccessResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface ReservationController {

	@ApiOperation(value = "Do Reservation")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Created", response = SuccessResponse.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = ErrorResponse.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource", response = ErrorResponse.class),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal validation error", response = ErrorResponse.class) })
	public ResponseEntity<SuccessResponse<HotelReservationResponse>> doHotelReservation(HotelReservationDTO hotelDTO);

	
	@ApiOperation(value = "Get Reservation Details")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Created", response = SuccessResponse.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = ErrorResponse.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource", response = ErrorResponse.class),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal validation error", response = ErrorResponse.class) })
	public ResponseEntity<SuccessResponse<HotelReservationResponse>> getReservationDetails(String reservationId);

}
