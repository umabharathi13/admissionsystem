package com.cg.admissionsystem.exception;

public class BranchNotFoundException extends RuntimeException {
	public BranchNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}
	public BranchNotFoundException(String message) {
		super(message);
	}
	public BranchNotFoundException(Throwable cause) {
		super(cause);
	}

}
