package com.emre.springdemo.core.utilities.results.controller;

public abstract class ControllerDataResult<T> extends ControllerResult {

	private T data;

	public ControllerDataResult(boolean success, int code, String message, T data) {
		super(success, code, message);
		this.data = data;
	}

	public T getData() {
		return data;
	}

}