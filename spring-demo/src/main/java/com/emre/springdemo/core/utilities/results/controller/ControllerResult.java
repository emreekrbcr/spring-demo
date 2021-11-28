package com.emre.springdemo.core.utilities.results.controller;

public abstract class ControllerResult {
	private boolean success;
	private int code; // client ile api arasında bir proxy olursa header'daki HTTPStatus kodunu
						// değiştirebilir, sonucun içerisinde de bildirmek best practice
	private String message;

	public ControllerResult(boolean success, int code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}