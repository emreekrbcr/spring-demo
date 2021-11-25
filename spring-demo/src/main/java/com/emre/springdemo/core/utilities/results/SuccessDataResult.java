package com.emre.springdemo.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data) {
		super(data, true);
	}

	public SuccessDataResult(T data, String ...messages) {
		super(data, true, messages);
	}
}