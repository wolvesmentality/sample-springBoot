package com.veosaf.bookRental.services;

import java.util.List;

import com.veosaf.bookRental.dto.UserDto;
import com.veosaf.bookRental.models.User;

public interface UserService {

	User getById(Long id);

	List<UserDto> findAllUsersDto();

	UserDto findById(Long id);

	User save(UserDto userDto);

	void delete(Long id);
}
