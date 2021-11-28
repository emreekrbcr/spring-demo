package com.emre.springdemo.core.utilities.results.controller;

import java.time.LocalDateTime;

public class ErrorDetailsMoreDetailed extends ErrorDetails{
	
	private Object errors;
	
	public ErrorDetailsMoreDetailed(Object errors) {
		super();
		this.errors=errors;
	}
	
	public ErrorDetailsMoreDetailed(String path, Object errors) {
		super(path);
		this.errors=errors;
	}
	
	public ErrorDetailsMoreDetailed(LocalDateTime timestamp, String path, Object errors) {
		super(timestamp, path);
		this.errors=errors;
	}

	public Object getErrors() {
		return errors;
	}
}