package com.emre.springdemo.core.crossCuttingConcerns.exceptionHandling;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String description;
	private String message;

	//status eklenecek ve description -> path olarak degisecek

	public ErrorDetails(Date timestamp, String description, String message) {
		this.timestamp = timestamp;
		this.description = description;
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
