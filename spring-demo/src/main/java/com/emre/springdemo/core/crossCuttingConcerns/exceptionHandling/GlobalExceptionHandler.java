package com.emre.springdemo.core.crossCuttingConcerns.exceptionHandling;

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
import com.emre.springdemo.core.utilities.results.controller.ControllerErrorResult;
import com.emre.springdemo.core.utilities.results.controller.ControllerResult;
import com.emre.springdemo.core.utilities.results.controller.ErrorDetails;
import com.emre.springdemo.core.utilities.results.controller.ErrorDetailsMoreDetailed;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// specific exceptions---------------------------------------

	// for resource not found

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
		HttpStatus statusCode = HttpStatus.NOT_FOUND;
		ErrorDetails errorDetails = new ErrorDetails(request.getDescription(false));
		ControllerResult controllerResult = new ControllerErrorResult(statusCode.value(),
				Messages.ExceptionMessages.RESOURCE_NOT_FOUND, errorDetails);
		return new ResponseEntity<Object>(controllerResult, statusCode);
	}

	// for validation

	// @ResponseStatus(code = HttpStatus.BAD_REQUEST) ResponseEntity döndürmeseydik
	// böyle yapabilirdik
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleResourceNotFoundException(MethodArgumentNotValidException exception,
			WebRequest request) {
		HttpStatus statusCode = HttpStatus.BAD_REQUEST;
		Map<String, String> validationErrors = new HashMap<>();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDetails errorDetails = new ErrorDetailsMoreDetailed(request.getDescription(false), validationErrors);
		ControllerResult controllerResult = new ControllerErrorResult(statusCode.value(),
				Messages.ExceptionMessages.VALIDATION_EXCEPTION, errorDetails);
		return new ResponseEntity<Object>(controllerResult, statusCode);
	}

	// global exceptions--------------------------------------------

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleResourceNotFoundException(Exception exception, WebRequest request) {
		HttpStatus statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorDetails errorDetails = new ErrorDetails(request.getDescription(false));
		ControllerResult controllerResult = new ControllerErrorResult(statusCode.value(),
				Messages.ExceptionMessages.GLOBAL_EXCEPTION, errorDetails);
		return new ResponseEntity<Object>(controllerResult, statusCode);
	}

}
