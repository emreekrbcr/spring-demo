package com.emre.springdemo.core.crossCuttingConcerns.exceptionHandling;

import java.util.Date;

public class ErrorDetailsMoreDetails extends ErrorDetails {
	private Object messageDetails;

	public ErrorDetailsMoreDetails(Date timestamp, String description, String message, Object messageDetails) {
		super(timestamp, description, message);
		this.messageDetails = messageDetails;
	}

	public Object getMessageDetails() {
		return messageDetails;
	}

	public void setMessageDetails(Object messageDetails) {
		this.messageDetails = messageDetails;
	}
}