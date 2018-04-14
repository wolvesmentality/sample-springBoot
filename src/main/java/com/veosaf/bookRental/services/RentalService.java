package com.veosaf.bookRental.services;

import java.util.List;

import com.veosaf.bookRental.dto.RentalDto;
import com.veosaf.bookRental.exception.PersistDataException;
import com.veosaf.bookRental.models.Rental;

public interface RentalService {

	List<Rental> findAllRentals();

	List<RentalDto> findAllRentalsDto();

	RentalDto findById(Long id);

	Rental getRentalById(Long id);

	Rental save(RentalDto rentalDto) throws PersistDataException;

	void delete(Long id);

}
