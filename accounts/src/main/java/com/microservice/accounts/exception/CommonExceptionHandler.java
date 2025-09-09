package com.microservice.accounts.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.microservice.accounts.dto.ErrorDetailsDTO;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomerExistsException.class)
	public ResponseEntity<ErrorDetailsDTO> handleUserPresentException(CustomerExistsException ex, WebRequest request) {

		ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(request.getDescription(false), "CUSTOMER_ALREADY_EXISTS",
				ex.getMessage(), java.time.LocalDateTime.now());
		return new ResponseEntity<>(errorDetails, org.springframework.http.HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity<ErrorDetailsDTO> handleResourceNotFoundException(ResourceNotFound ex, WebRequest request) {

		ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(request.getDescription(false),
				org.springframework.http.HttpStatus.NOT_FOUND.toString(), ex.getMessage(),
				java.time.LocalDateTime.now());
		return new ResponseEntity<>(errorDetails, org.springframework.http.HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Object> handleRuntimeException(RuntimeException ex, WebRequest request) {

		ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(request.getDescription(false),
				HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage(), java.time.LocalDateTime.now());
		return new ResponseEntity<>(errorDetails, org.springframework.http.HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		Map<String, String> validationErrors=new HashMap<>();
		
		List<ObjectError> validationErrorList=ex.getBindingResult().getAllErrors();
		
		validationErrorList.forEach((error)->{
			String fieldName=((FieldError) error).getField();
			String err= error.getDefaultMessage();
			validationErrors.put(fieldName, err);
		});
		
		
		ErrorDetailsDTO errorDetails = new ErrorDetailsDTO(request.getDescription(false),
				HttpStatus.BAD_REQUEST.toString(), ex.getFieldError().getDefaultMessage(),
				java.time.LocalDateTime.now());

		return new ResponseEntity(validationErrors, HttpStatus.BAD_REQUEST);
	}
}
