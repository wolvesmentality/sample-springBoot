package com.veosaf.bookRental.resources.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.veosaf.bookRental.dto.UserDto;
import com.veosaf.bookRental.models.User;
import com.veosaf.bookRental.resources.UserResource;
import com.veosaf.bookRental.services.UserService;

public class UserResourceImpl implements UserResource {

	@Inject
	private UserService userService;

	@Override
	public Response findAll() {
		List<UserDto> usersDto = userService.findAllUsersDto();
		return Response.ok(usersDto).build();
	}

	@Override
	public Response findById(Long id) {
		UserDto user = userService.findById(id);
		return Response.ok(user).build();
	}

	@Override
	public Response save(UserDto userDto) {
		User user = userService.save(userDto);
		return Response.ok(user.getId()).build();
	}

	@Override
	public Response delete(Long id) {
		UserDto user = userService.findById(id);
		if (user == null) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("User with ID# " + id + " not found")
					.type(MediaType.APPLICATION_JSON).build();
		}
		userService.delete(id);
		return null;
	}

}
