package com.emre.springdemo.core.utilities.results.service;

public class ErrorResult extends Result{

	public ErrorResult() {
		super(false);
	}

	public ErrorResult(String... messages) {
		super(false,messages);
	}

}