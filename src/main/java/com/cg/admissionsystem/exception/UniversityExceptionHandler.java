package com.cg.admissionsystem.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.admissionsystem.module.UniversityErrorResponse;

@ControllerAdvice
public class UniversityExceptionHandler {
	@ExceptionHandler
	public  ResponseEntity<UniversityErrorResponse> handleException(UniversityNotFoundException e){
		UniversityErrorResponse err=new UniversityErrorResponse();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(e.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public  ResponseEntity<UniversityErrorResponse> handleException(Exception e){
		UniversityErrorResponse err=new UniversityErrorResponse();
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(e.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}

}



