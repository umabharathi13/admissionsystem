package com.cg.admissionsystem.exception;

public class AddressNotFoundException extends RuntimeException {

	public AddressNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public AddressNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}