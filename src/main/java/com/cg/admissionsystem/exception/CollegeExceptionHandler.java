package com.cg.admissionsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cg.admissionsystem.module.CollegeErrorResponse;

@ControllerAdvice
public class CollegeExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CollegeErrorResponse> handleException(CollegeNotFoundException e) {
		CollegeErrorResponse collegeErrorResponse = new CollegeErrorResponse();
		collegeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		collegeErrorResponse.setMessage(e.getMessage());
		collegeErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(collegeErrorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CollegeErrorResponse> handleException(Exception e) {
		CollegeErrorResponse collegeErrorResponse = new CollegeErrorResponse();
		collegeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		collegeErrorResponse.setMessage(e.getMessage());
		collegeErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(collegeErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
