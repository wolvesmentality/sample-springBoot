package com.veosaf.bookRental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.veosaf.bookRental.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	Book findByTitle(String title);

	Book findById(Long id);

	@Query(value = "Select book from Book book where book.isAvailable = TRUE")
	List<Book> findAllAvailableBooksDto();

}
