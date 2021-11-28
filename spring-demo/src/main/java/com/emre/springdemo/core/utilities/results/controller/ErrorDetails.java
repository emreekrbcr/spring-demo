package com.emre.springdemo.core.utilities.results.controller;

import java.time.LocalDateTime;

public class ErrorDetails {
	private LocalDateTime timestamp;
	private String path;
	
	public ErrorDetails() {
		this.timestamp=LocalDateTime.now();
	}
	
	public ErrorDetails(String path) {
		this();
		this.path=path;
	}
	
	public ErrorDetails(LocalDateTime timestamp, String path) {
		this.timestamp = timestamp;
		this.path = path;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public String getPath() {
		return path;
	}
}