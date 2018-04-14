package com.veosaf.bookRental.dtoMappers;

import java.util.List;

import com.veosaf.bookRental.dto.UserDto;
import com.veosaf.bookRental.models.User;

public interface UserDtoMapper {

	UserDto toUserDto(User user);

	List<UserDto> toUsersDto(List<User> findAll);

	User toUser(UserDto userDto);

}
