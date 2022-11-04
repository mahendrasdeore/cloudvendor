package com.cloudvendor.exception;

public class ExceptionApi {
	
	
	private String message;
	
	private boolean value;
	

	public ExceptionApi(String message, boolean value) {
		super();
		this.message = message;
		this.value = value;
	}

	public String getMessage() {
		return message;
	}

	public boolean isValue() {
		return value;
	}
	
	

}
