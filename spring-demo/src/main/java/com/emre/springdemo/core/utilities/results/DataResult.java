package com.emre.springdemo.core.utilities.results;

public abstract class DataResult<T> extends Result {

	private final T data;

	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}

	public DataResult(T data, boolean success, String ...messages) {
		super(success, messages);
		this.data = data;
	}

	public T getData() {
		return data;
	}

}