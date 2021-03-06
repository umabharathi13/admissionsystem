package com.cg.admissionsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.admissionsystem.module.AdmissionErrorMessage;

@ControllerAdvice
public class AdmissionExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<AdmissionErrorMessage> handleException(AdmissionNotFoundException e) {
		AdmissionErrorMessage error = new AdmissionErrorMessage();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
