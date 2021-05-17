package com.cg.admissionsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.admissionsystem.module.AddressErrorMessage;

@ControllerAdvice
public class AddressExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<AddressErrorMessage> handleException(AddressNotFoundException e){
		AddressErrorMessage error=new AddressErrorMessage();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	/*@ExceptionHandler
	public ResponseEntity<AddressErrorMessage> handleException(Exception e){
		AddressErrorMessage error=new AddressErrorMessage();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage("ENTER THE VALID ID");
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}*/

}
