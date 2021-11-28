package com.emre.springdemo.core.utilities.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.emre.springdemo.core.utilities.constants.Messages;
import com.emre.springdemo.core.utilities.results.controller.ControllerDataResult;
import com.emre.springdemo.core.utilities.results.controller.ControllerErrorDataResult;
import com.emre.springdemo.core.utilities.results.controller.ControllerResult;
import com.emre.springdemo.core.utilities.results.controller.ControllerSuccessDataResult;
import com.emre.springdemo.core.utilities.results.controller.ControllerSuccessResult;
import com.emre.springdemo.core.utilities.results.controller.ErrorDetails;
import com.emre.springdemo.core.utilities.results.controller.ErrorDetailsMoreDetailed;
import com.emre.springdemo.core.utilities.results.service.DataResult;
import com.emre.springdemo.core.utilities.results.service.Result;

public class ControllerHelper {
	public static ResponseEntity<?> returnCommonResponseModel(Result result) {
		HttpStatus statusCode = HttpStatus.OK;
		ControllerResult controllerResult;
		if (!result.isSuccess()) {
			statusCode = HttpStatus.BAD_REQUEST;
			ErrorDetails errorDetails = new ErrorDetailsMoreDetailed(result.getMessages());
			controllerResult = new ControllerErrorDataResult<>(statusCode.value(),
					Messages.ExceptionMessages.SERVICE_RULES_EXCEPTION, errorDetails);
			return new ResponseEntity<Object>(controllerResult, statusCode);
		}
		controllerResult = new ControllerSuccessResult(statusCode.value(), result.getMessages()[0]);
		return new ResponseEntity<Object>(result,statusCode);
	}

	public static <T> ResponseEntity<?> returnCommonResponseModel(DataResult<T> dataResult) {
		HttpStatus statusCode = HttpStatus.OK;
		ControllerDataResult<T> controllerDataResult;
		if (!dataResult.isSuccess()) {
			statusCode = HttpStatus.BAD_REQUEST;
			ErrorDetails errorDetails = new ErrorDetailsMoreDetailed(dataResult.getMessages());
			controllerDataResult = new ControllerErrorDataResult<>(statusCode.value(),
					Messages.ExceptionMessages.SERVICE_RULES_EXCEPTION, errorDetails);
			return new ResponseEntity<Object>(controllerDataResult, statusCode);
		}
		controllerDataResult = new ControllerSuccessDataResult<>(statusCode.value(), dataResult.getMessages()[0],
				dataResult.getData());
		return new ResponseEntity<Object>(controllerDataResult,statusCode);
			
	}
}
