package com.emre.springdemo.core.crossCuttingConcerns.exceptionHandling.customExceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
