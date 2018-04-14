package com.veosaf.bookRental.resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.veosaf.bookRental.dto.RentalDto;

@Path("/rental")
public interface RentalResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	Response findAll();

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	Response save(RentalDto rentalDto);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	Response findById(@PathParam("id") Long id);

}
