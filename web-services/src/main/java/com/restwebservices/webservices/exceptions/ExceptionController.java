package com.restwebservices.webservices.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class ExceptionController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public  ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionResponse exRes = new ExceptionResponse(new Date(), ex.getMessage(), "");
		return new ResponseEntity(exRes, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public  ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) throws Exception {
		ExceptionResponse exRes = new ExceptionResponse(new Date(), ex.getMessage(), "");
		return new ResponseEntity(exRes, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>(ex.getBindingResult().getAllErrors(), HttpStatus.BAD_REQUEST);
//		return new ResponseEntity<Object>(new ExceptionResponse(new Date(), "Input model is invalid", ex.getBindingResult().getAllErrors().toString()), HttpStatus.BAD_REQUEST);
	}
}
