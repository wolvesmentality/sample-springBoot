package com.veosaf.bookRental.exception;

public class PersistDataException extends Exception {

	private static final long serialVersionUID = 1L;

	public PersistDataException(String message) {
		super(message);
	}

	public PersistDataException(String message, Throwable cause) {
		super(message, cause);
	}
}
