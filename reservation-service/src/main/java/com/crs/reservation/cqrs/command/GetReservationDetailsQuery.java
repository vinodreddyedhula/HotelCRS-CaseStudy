package com.crs.reservation.cqrs.command;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetReservationDetailsQuery {

	private UUID reservationId;

}
