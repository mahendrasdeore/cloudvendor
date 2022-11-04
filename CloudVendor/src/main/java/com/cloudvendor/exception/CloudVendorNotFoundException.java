package com.cloudvendor.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorNotFoundException{
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ExceptionApi> cloudException(NoSuchElementException ex){
		
		
	String message=ex.getMessage();
	boolean value=false;
	return new ResponseEntity<ExceptionApi>(new ExceptionApi(message, value),HttpStatus.NOT_FOUND);
		
	}

}
