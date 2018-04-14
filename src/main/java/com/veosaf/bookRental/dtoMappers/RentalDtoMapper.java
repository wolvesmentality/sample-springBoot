package com.veosaf.bookRental.dtoMappers;

import java.util.List;

import com.veosaf.bookRental.dto.RentalDto;
import com.veosaf.bookRental.exception.DataNotFoundException;
import com.veosaf.bookRental.models.Rental;

public interface RentalDtoMapper {

	RentalDto toRentalDto(Rental rental);

	List<RentalDto> toRentalsDto(List<Rental> rentals);

	Rental toRental(RentalDto rentalDto) throws DataNotFoundException;

}
