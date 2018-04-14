package com.veosaf.bookRental.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(value = "/appsetting")
public interface AppSettingResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{name}")
	Response getAppSettingByName(@PathParam("name") String name);

}
