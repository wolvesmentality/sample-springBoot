package com.veosaf.bookRental.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.veosaf.bookRental.dto.RentalDto;
import com.veosaf.bookRental.dtoMappers.RentalDtoMapper;
import com.veosaf.bookRental.exception.DataNotFoundException;
import com.veosaf.bookRental.exception.PersistDataException;
import com.veosaf.bookRental.models.Book;
import com.veosaf.bookRental.models.Rental;
import com.veosaf.bookRental.models.User;
import com.veosaf.bookRental.repository.BookRepository;
import com.veosaf.bookRental.repository.RentalRepository;
import com.veosaf.bookRental.repository.UserRepository;
import com.veosaf.bookRental.services.RentalService;

@Service
public class RentalServiceImpl implements RentalService {

	@Inject
	private RentalRepository rentalRepository;

	@Inject
	private BookRepository bookRepository;

	@Inject
	private UserRepository userRepository;

	@Inject
	private RentalDtoMapper rentalDtoMapper;

	@Override
	public List<Rental> findAllRentals() {
		return rentalRepository.findAll();
	}

	@Override
	@Transactional
	public List<RentalDto> findAllRentalsDto() {
		return rentalDtoMapper.toRentalsDto(rentalRepository.findAll());
	}

	@Override
	@Transactional
	public RentalDto findById(Long id) {
		return id == null ? null : rentalDtoMapper.toRentalDto(rentalRepository.findOne(id));
	}

	@Override
	public Rental getRentalById(Long id) {
		return id == null ? null : rentalRepository.getOne(id);
	}

	@Override
	@Transactional
	public Rental save(RentalDto rentalDto) throws PersistDataException {
		Rental rental = null;
		if (rentalDto.getId() != null) {
			rental = rentalRepository.findOne(rentalDto.getId());
			if (rental == null) {
				throw new PersistDataException("Rental not found");
			}
		}
		Book book = getBookFromRental(rentalDto);

		if (book == null) {
			throw new PersistDataException("Cannot save a rental with a non valid book");
		} else if (Boolean.FALSE.equals(book.getIsAvailable())) {
			throw new PersistDataException("The book with title " + book.getTitle() + " is not available");
		}

		User user = getUserFromRental(rentalDto);
		if (user == null) {
			throw new PersistDataException("Cannot save a rental with a non user book");
		}

		book = bookRepository.save(book);
		try {
			rental = rentalRepository.save(rentalDtoMapper.toRental(rentalDto));
		} catch (DataNotFoundException e) {
			throw new PersistDataException(e.getMessage());
		}
		return rental;
	}

	private Book getBookFromRental(RentalDto rentalDto) {
		Book book = null;
		if (rentalDto.getBook() != null && rentalDto.getBook().getId() != null) {
			book = bookRepository.findById(rentalDto.getBook().getId());
		}
		return book;
	}

	private User getUserFromRental(RentalDto rentalDto) {
		User user = null;
		if (rentalDto.getUser() != null && rentalDto.getUser().getId() != null) {
			user = userRepository.findOne(rentalDto.getUser().getId());
		}
		return user;
	}

	@Override
	public void delete(Long id) {
		rentalRepository.delete(id);
	}

}
