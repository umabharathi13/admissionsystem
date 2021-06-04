package com.cg.admissionsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.admissionsystem.module.ProgramErrorMessage;

@ControllerAdvice
public class ProgramExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ProgramErrorMessage> handleException(ProgramNotFoundException e){
		ProgramErrorMessage error=new ProgramErrorMessage();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);		
	}	
	@ExceptionHandler
	public ResponseEntity<ProgramErrorMessage> handleException(Exception e){
		ProgramErrorMessage error=new ProgramErrorMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);		
	}
	

}
