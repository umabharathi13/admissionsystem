package com.cg.admissionsystem.exception;

public class CourseNotFoundException extends RuntimeException {

	/**
	 * Super class for Exception
	 * 
	 * @param message
	 */

	public CourseNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CourseNotFoundException(String message) {
		super(message);
	}

	public CourseNotFoundException(Throwable cause) {
		super(cause);
	}

}
