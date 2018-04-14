package com.veosaf.bookRental.dtoMappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.veosaf.bookRental.dto.BookDto;
import com.veosaf.bookRental.dtoMappers.BookDtoMapper;
import com.veosaf.bookRental.models.Book;

@Service
public class BookDtoMapperImpl implements BookDtoMapper {

	@Override
	public BookDto toBookDto(Book book) {
		BookDto bookDto = null;
		if (book != null) {
			bookDto = new BookDto();
			bookDto.setId(book.getId());
			bookDto.setIsAvailable(book.getIsAvailable());
			bookDto.setTitle(book.getTitle());
			bookDto.setAuthor(book.getAuthor());
			bookDto.setPublicationDate(book.getPublicationDate());
		}
		return bookDto;
	}

	@Override
	public List<BookDto> toBooksDto(List<Book> books) {
		List<BookDto> booksDto = new ArrayList<BookDto>();
		if (books != null) {
			books.stream().forEach(book -> booksDto.add(toBookDto(book)));
		}
		return booksDto;
	}

	@Override
	public Book toBook(BookDto bookDto) {
		if (bookDto == null) {
			return null;
		}
		Book book = new Book();
		book.setTitle(bookDto.getTitle());
		book.setIsAvailable(bookDto.getIsAvailable());
		book.setAuthor(bookDto.getAuthor());
		book.setId(bookDto.getId());
		book.setPublicationDate(bookDto.getPublicationDate());
		return book;
	}

}
