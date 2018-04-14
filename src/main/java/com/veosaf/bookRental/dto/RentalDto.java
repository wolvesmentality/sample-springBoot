package com.veosaf.bookRental.dto;

import java.io.Serializable;
import java.util.Date;

public class RentalDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private BookDto book;

	private UserDto user;

	private Date startDate;

	private Date endDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
