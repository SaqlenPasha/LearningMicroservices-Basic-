package com.microservice.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code=HttpStatus.BAD_REQUEST, reason="Customer already exists")
public class CustomerExistsException extends RuntimeException {

	public CustomerExistsException(String message) {
		super(message);
	}

}
