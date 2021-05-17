package com.cg.admissionsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.admissionsystem.module.BranchErrorResponse;
import com.cg.admissionsystem.module.CollegeErrorresponse;

@ControllerAdvice
public class CollegeExceptionHandler {
	
	@ExceptionHandler
	public  ResponseEntity<CollegeErrorresponse> handleException(CollegeNotFoundException e){
		CollegeErrorresponse err=new CollegeErrorresponse();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(e.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public  ResponseEntity<CollegeErrorresponse> handleException(Exception e){
		CollegeErrorresponse err=new CollegeErrorresponse();
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(e.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}


}
