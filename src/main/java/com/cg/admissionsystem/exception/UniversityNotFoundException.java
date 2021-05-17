package com.cg.admissionsystem.exception;

public class UniversityNotFoundException extends RuntimeException{
	public UniversityNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}
	public UniversityNotFoundException(String message) {
		super(message);
	}
	public UniversityNotFoundException(Throwable cause) {
		super(cause);
	}

}
