package com.veosaf.bookRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veosaf.bookRental.models.Rental;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
