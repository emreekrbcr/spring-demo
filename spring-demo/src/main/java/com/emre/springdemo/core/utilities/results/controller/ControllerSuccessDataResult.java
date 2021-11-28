package com.emre.springdemo.core.utilities.results.controller;

import org.springframework.http.HttpStatus;

public class ControllerSuccessDataResult<T> extends ControllerDataResult<T> {

	public ControllerSuccessDataResult(String message, T data) {
		super(true, HttpStatus.OK.value(), message, data);
	}

	public ControllerSuccessDataResult(int code, String message, T data) {
		super(true, code, message, data);
	}

}