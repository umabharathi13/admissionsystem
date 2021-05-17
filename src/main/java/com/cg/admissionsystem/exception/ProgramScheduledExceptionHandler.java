package com.cg.admissionsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.admissionsystem.module.ProgramErrorMessage;
import com.cg.admissionsystem.module.ProgramScheduledErrorMessage;

@ControllerAdvice
public class ProgramScheduledExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ProgramScheduledErrorMessage> handleException(ProgramScheduledNotFoundException e){
		ProgramScheduledErrorMessage error=new ProgramScheduledErrorMessage();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);		
	}
	
	@ExceptionHandler
	public ResponseEntity<ProgramScheduledErrorMessage> handleException(Exception e){
		ProgramScheduledErrorMessage error=new ProgramScheduledErrorMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("Enter the valid ID");
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);		
	}
	
}
