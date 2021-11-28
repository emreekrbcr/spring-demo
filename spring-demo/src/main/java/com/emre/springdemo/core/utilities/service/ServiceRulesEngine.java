package com.emre.springdemo.core.utilities.service;

import java.util.ArrayList;
import java.util.List;

import com.emre.springdemo.core.utilities.results.service.ErrorResult;
import com.emre.springdemo.core.utilities.results.service.Result;
import com.emre.springdemo.core.utilities.results.service.SuccessResult;

public class ServiceRulesEngine {
	public static Result run(Result...rules) {
		List<String>errorMessages=new ArrayList<String>();
		
		for (Result rule:rules) {
			if (!rule.isSuccess()) {
				errorMessages.add(rule.getMessages()[0]);
			}
		}
		
		if (errorMessages.size()>0) {
			return new ErrorResult(errorMessages.toArray(new String[0]));
		}
		
		return new SuccessResult();
	}
}
