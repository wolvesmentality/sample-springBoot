package com.veosaf.bookRental.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.veosaf.bookRental.dto.BookDto;

@Path("/book")
public interface BookResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	Response findAll();

	@GET
	@Path("/available")
	@Produces(MediaType.APPLICATION_JSON)
	Response findAllAvailable();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	Response findById(@PathParam("id") Long id);

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	Response delete(@PathParam("id") Long id);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	Response save(BookDto bookDto);

}
