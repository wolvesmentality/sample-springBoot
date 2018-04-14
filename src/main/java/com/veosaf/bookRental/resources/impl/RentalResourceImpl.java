package com.veosaf.bookRental.resources.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.veosaf.bookRental.dto.RentalDto;
import com.veosaf.bookRental.exception.PersistDataException;
import com.veosaf.bookRental.models.Rental;
import com.veosaf.bookRental.resources.RentalResource;
import com.veosaf.bookRental.services.RentalService;

@Component
public class RentalResourceImpl implements RentalResource {

	@Inject
	private RentalService rentalService;

	@Override
	public Response findAll() {
		List<RentalDto> rentalsDto = rentalService.findAllRentalsDto();
		return Response.ok(rentalsDto).build();
	}

	@Override
	public Response save(RentalDto rentalDto) {
		Rental rental;
		try {
			rental = rentalService.save(rentalDto);
			return Response.ok(rental.getId()).build();
		} catch (PersistDataException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage())
					.type(MediaType.APPLICATION_JSON).build();
		}
	}

	@Override
	public Response findById(Long id) {
		RentalDto rental = rentalService.findById(id);
		return Response.ok(rental).build();
	}
}
