package com.emre.springdemo.core.crossCuttingConcerns.exceptionHandling;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.emre.springdemo.core.crossCuttingConcerns.exceptionHandling.customExceptions.ResourceNotFoundException;
import com.emre.springdemo.core.utilities.constants.Messages;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// specific exceptions---------------------------------------

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), request.getDescription(false), exception.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
	}

	// for validation

	//@ResponseStatus(code = HttpStatus.BAD_REQUEST) ResponseEntity döndürmeseydik böyle yapabilirdik
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleResourceNotFoundException(MethodArgumentNotValidException exception,
			WebRequest request) {
		Map<String, String> validationErrors = new HashMap<>();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDetailsMoreDetails errorDetails = new ErrorDetailsMoreDetails(new Date(), request.getDescription(false),
				Messages.ExceptionMessages.ValidationException, validationErrors);
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	// global exceptions--------------------------------------------

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleResourceNotFoundException(Exception exception, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), request.getDescription(false),
				Messages.ExceptionMessages.GlobalException);
		return new ResponseEntity<Object>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
