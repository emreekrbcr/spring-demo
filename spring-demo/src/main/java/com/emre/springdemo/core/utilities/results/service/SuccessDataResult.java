package com.emre.springdemo.core.utilities.results.service;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data) {
		super(data, true);
	}

	public SuccessDataResult(T data, String... messages) {
		super(data, true, messages);
	}
	
	public SuccessDataResult(String... messages) {
		super(null, true, messages);
	}
}