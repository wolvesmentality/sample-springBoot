package com.veosaf.bookRental.dtoMappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.veosaf.bookRental.dto.UserDto;
import com.veosaf.bookRental.dtoMappers.UserDtoMapper;
import com.veosaf.bookRental.models.User;

@Service
public class UserDtoMapperImpl implements UserDtoMapper {

	@Override
	public UserDto toUserDto(User user) {
		UserDto userDto = null;
		if (user == null) {
			return null;
		}
		userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());

		return userDto;
	}

	@Override
	public List<UserDto> toUsersDto(List<User> users) {
		List<UserDto> usersDto = new ArrayList<UserDto>();
		if (users != null) {
			users.stream().forEach(user -> usersDto.add(toUserDto(user)));
		}
		return usersDto;
	}

	@Override
	public User toUser(UserDto userDto) {
		if (userDto == null) {
			return null;
		}
		User user = new User();
		user.setId(userDto.getId());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setEmail(userDto.getEmail());
		return user;
	}

}
