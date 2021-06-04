package com.cg.admissionsystem.exception;

/**
 * Class ApplicationNotFoundException extends {@link java.lang.Exception}
 */
public class PaymentNotFoundException extends RuntimeException {

	/**
	 * Generated serialVersioUID
	 */
	private static final long serialVersionUID = 7307592686512161447L;

	/**
	 * Super class for Exception
	 */
	public PaymentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PaymentNotFoundException(String message) {
		super(message);
	}

	public PaymentNotFoundException(Throwable cause) {
		super(cause);
	}

}
