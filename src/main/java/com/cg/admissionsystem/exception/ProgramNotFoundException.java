package com.cg.admissionsystem.exception;

/**
 * Class ProgramNotFoundException extends {@link java.lang.Exception}
 * 
 * @author Brindha
 */
public class ProgramNotFoundException extends RuntimeException {
	
	/**
	 * Parameterized constructor
	 * 
	 * @param message,cause
	 */
	public ProgramNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Parameterized constructor
	 * 
	 * @param message
	 */
	public ProgramNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * Parameterized constructor
	 * 
	 * @param cause
	 */
	public ProgramNotFoundException(Throwable cause) {
		super(cause);
	}
}
