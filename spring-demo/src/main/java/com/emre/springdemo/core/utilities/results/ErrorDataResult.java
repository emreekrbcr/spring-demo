package com.emre.springdemo.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data) {
		super(data, false);
	}

	public ErrorDataResult(T data, String ...messages) {
		super(data, false, messages);
	}
}