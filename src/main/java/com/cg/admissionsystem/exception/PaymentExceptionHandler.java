package com.cg.admissionsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.cg.admissionsystem.module.PaymentErrorResponse;

@ControllerAdvice
public class PaymentExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<PaymentErrorResponse>handleException(PaymentNotFoundException e){
		PaymentErrorResponse error = new PaymentErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404
		error.setMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<PaymentErrorResponse> handleException(Exception exception) {
		PaymentErrorResponse error = new PaymentErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	

}
