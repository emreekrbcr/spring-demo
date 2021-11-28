package com.emre.springdemo.core.utilities.results.controller;

public class ControllerErrorDataResult<T> extends ControllerDataResult<T> {
	
	private ErrorDetails errorDetails;
	
	public ControllerErrorDataResult(int code, String message, T data,ErrorDetails errorDetails) {
		super(false,code,message,data);
		this.errorDetails=errorDetails;
	}
	
	public ControllerErrorDataResult(int code, String message, ErrorDetails errorDetails) {
		this(code, message, null, errorDetails);
	}

	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}
	
}