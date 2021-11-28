package com.emre.springdemo.core.utilities.constants;

public class Messages {
	public static class AuthMessages {
		public static class SuccessMessages {
			public static final String USER_REGISTERED = "User registered successfully";
			public static final String SUCCESSFUL_LOGIN = "Login was successful";
			public static final String ACCESS_TOKEN_CREATED = "Access token was created";
		}

		public static class ErrorMessages {
			public static final String AUTHORIZATION_DENIED = "Authorization denied. You have no permission on this operation";
			public static final String USER_NOT_FOUND = "User was not found";
			public static final String INVALID_PASSWORD = "Your password is invalid";
			public static final String USER_ALREADY_EXISTS = "User already exists";
		}
	}

	public static class SystemMessages {
		public static final String MAINTENANCE_TIME = "System under maintenance";
		public static final String OPERATION_SUCCEEDED = "Operation was succeeded";
		public static final String OPERATION_FAILED = "Operation was failed";

	}

	public static class ExceptionMessages {
		public static final String SERVICE_RULES_EXCEPTION="Service rules error has occurred in the system";
		
		public static final String VALIDATION_EXCEPTION = "Validation error has occurred in the system";
		public static final String GLOBAL_EXCEPTION = "An unknown error has occurred in the system";
		public static final String RESOURCE_NOT_FOUND = "Resource can not be found in the system";
	}
}
