package com.emre.springdemo.core.utilities.results.service;

public class SuccessResult extends Result{

	public SuccessResult() {
		super(true);
	}

	public SuccessResult(String... messages) {
		super(true,messages);
	}

}
