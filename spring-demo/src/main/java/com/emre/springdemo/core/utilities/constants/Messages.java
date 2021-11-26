package com.emre.springdemo.core.utilities.constants;

public class Messages {
	public static class AuthMessages {
		public static class SuccessMessages {
			public static final String UserRegistered = "User registered successfully";
			public static final String SuccessfulLogin = "Login was successful";
			public static final String AccessTokenCreated = "Access token was created";
		}

		public static class ErrorMessages {
			public static final String AuthorizationDenied = "Authorization denied. You have no permission on this operation";
			public static final String UserNotFound = "User was not found";
			public static final String InvalidPassword = "Your password is invalid";
			public static final String UserAlreadyExists = "User already exists";
		}
	}

	public static class SystemMessages {
		public static final String MaintenanceTime = "System under maintenance";
		public static final String OperationSucceeded = "Operation was succeeded";
		public static final String OperationFailed = "Operation was failed";

	}

	public static class ExceptionMessages {
		public static final String ValidationException = "Validation error has occurred in the system";
		public static final String GlobalException = "An unknown error has occurred in the system";
	}
}
