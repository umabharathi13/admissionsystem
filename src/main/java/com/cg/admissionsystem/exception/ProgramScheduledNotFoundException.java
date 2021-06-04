package com.cg.admissionsystem.exception;

/**
 * Class ProgramScheduleNotFoundException extends {@link java.lang.Exception}
 * 
 * @author Brindha
 */

public class ProgramScheduledNotFoundException extends RuntimeException {

	/**
	 * Parameterized constructor
	 * 
	 * @param message,cause
	 */
	public ProgramScheduledNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param message
	 */
	public ProgramScheduledNotFoundException(String message) {
		super(message);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param cause
	 */
	public ProgramScheduledNotFoundException(Throwable cause) {
		super(cause);
	}

}
