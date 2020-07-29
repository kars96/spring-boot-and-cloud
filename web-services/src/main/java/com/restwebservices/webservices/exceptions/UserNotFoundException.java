package com.restwebservices.webservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundException extends ResourceNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String string) {
		super(string);
		}

}
