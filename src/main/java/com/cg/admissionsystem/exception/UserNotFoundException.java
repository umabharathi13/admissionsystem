package com.cg.admissionsystem.exception;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public UserNotFoundException(String message) {
		super(message);

	}

	public UserNotFoundException(Throwable cause) {
		super(cause);

	}
}
