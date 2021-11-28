package com.emre.springdemo.core.utilities.results.controller;

public class ControllerErrorResult extends ControllerResult {

	private ErrorDetails errorDetails;

	public ControllerErrorResult(int code, String message, ErrorDetails errorDetails) {
		super(false, code, message);
		this.errorDetails = errorDetails;
	}

	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}

}