package com.cg.admissionsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.admissionsystem.module.UniversityErrorResponse;

@ControllerAdvice
public class UniversityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<UniversityErrorResponse> handleException(UniversityNotFoundException e) {
		UniversityErrorResponse universityErrorResponse = new UniversityErrorResponse();
		universityErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		universityErrorResponse.setMessage(e.getMessage());
		universityErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(universityErrorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<UniversityErrorResponse> handleException(Exception e) {
		UniversityErrorResponse universityErrorResponse = new UniversityErrorResponse();
		universityErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		universityErrorResponse.setMessage(e.getMessage());
		universityErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(universityErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
