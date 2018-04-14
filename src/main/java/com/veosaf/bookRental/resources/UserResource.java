package com.veosaf.bookRental.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.veosaf.bookRental.dto.UserDto;

@Path("/user")
public interface UserResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	Response findAll();

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
	Response save(UserDto userDto);

}
