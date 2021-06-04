package com.cg.admissionsystem.exception;

/**
 * Class ApplicationNotFoundException extends {@link java.lang.Exception}
 */
public class ApplicationNotFoundException extends RuntimeException {

	/**
	 * Generated serialVersioUID
	 */
	private static final long serialVersionUID = 2917969431034681587L;

	/**
	 * Super class for Exception
	 */
	public ApplicationNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationNotFoundException(String message) {
		super(message);
	}

	public ApplicationNotFoundException(Throwable cause) {
		super(cause);
	}

}
