package com.emre.springdemo.core.utilities.results.service;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data) {
		super(data, false);
	}

	public ErrorDataResult(T data, String... messages) {
		super(data, false, messages);
	}
	
	public ErrorDataResult(String ...messages) {
		super(null, false, messages);
	}
}