package com.veosaf.bookRental.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.veosaf.bookRental.dto.UserDto;
import com.veosaf.bookRental.dtoMappers.UserDtoMapper;
import com.veosaf.bookRental.models.User;
import com.veosaf.bookRental.repository.UserRepository;
import com.veosaf.bookRental.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private UserRepository userRepository;

	@Inject
	private UserDtoMapper userDtoMapper;

	@Override
	public User getById(Long id) {
		if (id == null) {
			return null;
		}
		return userRepository.getOne(id);

	}

	@Override
	public List<UserDto> findAllUsersDto() {
		return userDtoMapper.toUsersDto(userRepository.findAll());
	}

	@Override
	public UserDto findById(Long id) {
		return userDtoMapper.toUserDto(userRepository.findOne(id));
	}

	@Override
	public User save(UserDto userDto) {
		return userRepository.save(userDtoMapper.toUser(userDto));
	}

	@Override
	@Transactional
	public void delete(Long id) {
		userRepository.delete(id);
	}

}
