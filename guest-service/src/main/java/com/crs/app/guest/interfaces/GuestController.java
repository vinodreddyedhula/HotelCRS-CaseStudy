package com.crs.app.guest.interfaces;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crs.app.guest.dto.ErrorResponse;
import com.crs.app.guest.dto.GuestDTO;
import com.crs.app.guest.dto.SuccessResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RequestMapping(value = "/api/v1/")
public interface GuestController {

	@ApiOperation(value = "Add Guest Details")
	 @ApiResponses(value= {
			 @ApiResponse(code=200,message="Successfully Created",response=SuccessResponse.class),
			 @ApiResponse(code=400,message="Invalid Request",response=ErrorResponse.class),
			 @ApiResponse(code=401,message="You are not authorized to view the resource",response=ErrorResponse.class),
			 @ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden",response=ErrorResponse.class),
			 @ApiResponse(code=404,message="The resource you were trying to reach is not found",response=ErrorResponse.class),
			 @ApiResponse(code=500,message="Internal validation error",response=ErrorResponse.class)
	 })
	@PostMapping("guests")
	public ResponseEntity<SuccessResponse<GuestDTO>> add(@Valid @RequestBody GuestDTO guestDTO);

	@ApiOperation(value = "Update Guest Details")
	 @ApiResponses(value= {
			 @ApiResponse(code=200,message="Successfully Created",response=SuccessResponse.class),
			 @ApiResponse(code=400,message="Invalid Request",response=ErrorResponse.class),
			 @ApiResponse(code=401,message="You are not authorized to view the resource",response=ErrorResponse.class),
			 @ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden",response=ErrorResponse.class),
			 @ApiResponse(code=404,message="The resource you were trying to reach is not found",response=ErrorResponse.class),
			 @ApiResponse(code=500,message="Internal validation error",response=ErrorResponse.class)
	 })
	@PutMapping("guests/{guest-id}")
	public ResponseEntity<SuccessResponse<GuestDTO>> update(@Valid @RequestBody GuestDTO guestDTO,
			@NotNull(message = "Guest Id cannot be Empty") @PathVariable(value="guest-id",required=true,name = "guest-id") String id);

	@ApiOperation(value = "Fetch Guest Details")
	 @ApiResponses(value= {
			 @ApiResponse(code=200,message="Successfully Created",response=SuccessResponse.class),
			 @ApiResponse(code=400,message="Invalid Request",response=ErrorResponse.class),
			 @ApiResponse(code=401,message="You are not authorized to view the resource",response=ErrorResponse.class),
			 @ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden",response=ErrorResponse.class),
			 @ApiResponse(code=404,message="The resource you were trying to reach is not found",response=ErrorResponse.class),
			 @ApiResponse(code=500,message="Internal validation error",response=ErrorResponse.class)
	 })
	@GetMapping("guests/{guest-id}")
	public ResponseEntity<SuccessResponse<GuestDTO>> get(@NotNull(message = "Guest Id cannot be Empty") @PathVariable(value="guest-id",required=true,name = "guest-id") String id);
	
	 @ApiOperation(value="Delete Guest Details")
	 @ApiResponses(value= {
			 @ApiResponse(code=200,message="Successfully Deleted",response=SuccessResponse.class),
			 @ApiResponse(code=400,message="Invalid Request",response=ErrorResponse.class),
			 @ApiResponse(code=401,message="You are not authorized to view the resource",response=ErrorResponse.class),
			 @ApiResponse(code=403,message="Accessing the resource you were trying to reach is forbidden",response=ErrorResponse.class),
			 @ApiResponse(code=404,message="The resource you were trying to reach is not found",response=ErrorResponse.class),
			 @ApiResponse(code=500,message="Internal validation error",response=ErrorResponse.class)
	 })
	@DeleteMapping("guests/{guest-id}")
	public ResponseEntity<SuccessResponse<GuestDTO>> delete(@NotNull(message = "Guest Id cannot be Empty") @PathVariable(value="guest-id",required=true,name = "guest-id") String id);

}
