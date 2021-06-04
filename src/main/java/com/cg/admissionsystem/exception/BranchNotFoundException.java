package com.cg.admissionsystem.exception;

public class BranchNotFoundException extends RuntimeException {

	/**
	 * Super class for Exception
	 * 
	 * @param message
	 */

	public BranchNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public BranchNotFoundException(String message) {
		super(message);
	}

	public BranchNotFoundException(Throwable cause) {
		super(cause);
	}

}
