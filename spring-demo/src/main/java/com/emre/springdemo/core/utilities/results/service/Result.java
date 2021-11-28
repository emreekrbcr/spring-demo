package com.emre.springdemo.core.utilities.results.service;

//lombok burada kullanılmaz. Genelde sadece entity'ler için kullanılır

public abstract class Result {

	private final boolean success;
	private String[] messages;

	public Result(boolean success) {

		this.success = success;
	}

	public Result(boolean success, String... messages) {
		this(success);
		this.messages = messages;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public String[] getMessages() {
		return this.messages;
	}
}