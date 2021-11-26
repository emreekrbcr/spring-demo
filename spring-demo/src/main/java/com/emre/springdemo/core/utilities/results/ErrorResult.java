package com.emre.springdemo.core.utilities.results;

public class ErrorResult extends Result{

	public ErrorResult() {
		super(false);
	}

	public ErrorResult(String ...messages) {
		super(false,messages);
	}

}