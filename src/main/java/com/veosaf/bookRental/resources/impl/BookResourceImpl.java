package com.veosaf.bookRental.resources.impl;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.veosaf.bookRental.dto.BookDto;
import com.veosaf.bookRental.models.Book;
import com.veosaf.bookRental.resources.BookResource;
import com.veosaf.bookRental.services.BookService;

@Component
public class BookResourceImpl implements BookResource {

	@Inject
	private BookService bookBusinessService;

	@Override
	public Response findAll() {
		List<BookDto> booksDto = bookBusinessService.findAllBooksDto();
		return Response.ok(booksDto).build();
	}

	@Override
	public Response findAllAvailable() {
		List<BookDto> booksDto = bookBusinessService.findAllAvailableBooksDto();
		return Response.ok(booksDto).build();
	}

	@Override
	public Response findById(Long id) {
		BookDto book = bookBusinessService.findById(id);
		return Response.ok(book).build();
	}

	@Override
	public Response save(BookDto bookDto) {
		Book book = bookBusinessService.save(bookDto);
		return Response.ok(book.getId()).build();
	}

	@Override
	public Response delete(Long id) {
		BookDto book = bookBusinessService.findById(id);
		if (book == null) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Book with ID# " + id + " not found")
					.type(MediaType.APPLICATION_JSON).build();
		}
		bookBusinessService.delete(id);
		return null;
	}

}
