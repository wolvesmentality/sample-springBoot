package com.veosaf.bookRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veosaf.bookRental.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
