package com.emre.springdemo.core.utilities.results.controller;

import org.springframework.http.HttpStatus;

public class ControllerSuccessResult extends ControllerResult {

	public ControllerSuccessResult(String message) { // olumlu donerken genelde OK kullanacagimizdan dolayi
		super(true, HttpStatus.OK.value(), message);
	}

	public ControllerSuccessResult(int code, String message) {
		super(true, code, message);
	}

}