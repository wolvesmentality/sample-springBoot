package com.veosaf.bookRental.dtoMappers.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.veosaf.bookRental.dto.RentalDto;
import com.veosaf.bookRental.dtoMappers.BookDtoMapper;
import com.veosaf.bookRental.dtoMappers.RentalDtoMapper;
import com.veosaf.bookRental.dtoMappers.UserDtoMapper;
import com.veosaf.bookRental.exception.DataNotFoundException;
import com.veosaf.bookRental.models.Book;
import com.veosaf.bookRental.models.Rental;
import com.veosaf.bookRental.models.User;
import com.veosaf.bookRental.services.BookService;
import com.veosaf.bookRental.services.UserService;

@Service
public class RentalDtoMapperImpl implements RentalDtoMapper {

	@Inject
	private BookDtoMapper bookDtoMapper;

	@Inject
	private UserDtoMapper userDtoMapper;

	@Inject
	private BookService bookService;

	@Inject
	private UserService userService;

	@Override
	public RentalDto toRentalDto(Rental rental) {
		RentalDto rentalDto = null;
		if (rental != null) {
			rentalDto = new RentalDto();
			rentalDto.setId(rental.getId());
			rentalDto.setEndDate(rental.getEndDate());
			rentalDto.setStartDate(rental.getStartDate());
			if (rental.getBook() != null) {
				rentalDto.setBook(bookDtoMapper.toBookDto(rental.getBook()));
			}
			if (rental.getUser() != null) {
				rentalDto.setUser(userDtoMapper.toUserDto(rental.getUser()));
			}

		}
		return rentalDto;
	}

	@Override
	public List<RentalDto> toRentalsDto(List<Rental> rentals) {
		List<RentalDto> rentalsDto = new ArrayList<RentalDto>();
		if (rentals != null) {
			rentals.stream().forEach(rental -> rentalsDto.add(toRentalDto(rental)));
		}
		return rentalsDto;
	}

	@Override
	public Rental toRental(RentalDto rentalDto) throws DataNotFoundException {
		if (rentalDto == null) {
			return null;
		}
		Rental rental = new Rental();
		rental.setId(rentalDto.getId());
		rental.setEndDate(rentalDto.getEndDate());
		rental.setStartDate(rentalDto.getStartDate());
		Book book = null;
		if (rentalDto.getBook() != null && rentalDto.getBook().getId() != null) {
			book = bookService.getBookById(rentalDto.getBook().getId());
			if (book == null) {
				throw new DataNotFoundException("No book with id " + rentalDto.getBook().getId());
			}
		}
		rental.setBook(book);
		User user = null;
		if (rentalDto.getUser() != null && rentalDto.getUser().getId() != null) {
			user = userService.getById(rentalDto.getUser().getId());
			if (user == null) {
				throw new DataNotFoundException("No user with id " + rentalDto.getUser().getId());
			}
		}
		rental.setUser(user);
		return rental;
	}

}
