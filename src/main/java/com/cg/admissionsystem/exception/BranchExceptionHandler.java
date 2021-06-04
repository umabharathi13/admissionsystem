package com.cg.admissionsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.admissionsystem.module.BranchErrorResponse;

@ControllerAdvice
public class BranchExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<BranchErrorResponse> handleException(BranchNotFoundException e) {
		BranchErrorResponse err = new BranchErrorResponse();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(e.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<BranchErrorResponse> handleException(Exception e) {
		BranchErrorResponse err = new BranchErrorResponse();
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(e.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

}
