package com.cg.admissionsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.exception.ApplicationNotFoundException;
import com.cg.admissionsystem.module.Application;
import com.cg.admissionsystem.service.IApplicationService;


@RestController
public class ApplicationController {
	
	@Autowired
	IApplicationService appService;
		
	
	@PostMapping("/application")
	public Application addApplication(@RequestBody Application application) {
		return appService.addApplication(application);
	}
	
	@GetMapping("/application")
	public List<Application>viewAllDetails(){
		return appService.viewAllApplicationDetails();
		}
	
	@GetMapping("/application/id/{id}")
	public Application GetApplicationById(@PathVariable("id") int applicationId) {
		if(appService.getApplicationById(applicationId) == null) {
			throw new ApplicationNotFoundException("Application not found with given id: "+applicationId);
		}
		return appService.getApplicationById(applicationId);
	}
				
	
	@PatchMapping("/application/{id}")
	public Application updateApplicationStatus(@PathVariable("id") int id, @RequestBody Application application) {
		if(appService.updateApplicationStatus(id,application) == null) {
			throw new ApplicationNotFoundException("Application not found with given id: "+application);
		}
		return appService.updateApplicationStatus(id,application);
	}
		
	
	@GetMapping("/application/emailid/{emailid}")
	public Application findByEmailId(@PathVariable("emailid")String emailId) {
		if(appService.findByEmailId(emailId)==null) {
			throw new ApplicationNotFoundException("Application not found with given emailid:" + emailId);
		}
		return appService.findByEmailId(emailId);
		
	}	

	@GetMapping("/application/applicationstatus/{applicationstatus}")
	public List<Application> findByApplicationStatus(@PathVariable("applicationstatus")String applicationStatus){
		if(appService.findByApplicationStatus(applicationStatus)==null) {
			throw new ApplicationNotFoundException("Application not found with given applicationStatus:" + applicationStatus);
		}
		return appService.findByApplicationStatus(applicationStatus);
	}
	
	@DeleteMapping("/application/id/{id}")
	public Application deleteApplicationById(@PathVariable("id")int applicationId) {
		if(appService.deleteApplicationById(applicationId) == null) {
			throw new ApplicationNotFoundException("Application not found with given id: "+applicationId);
		}
		return appService.deleteApplicationById(applicationId);
	}
	
		
	@DeleteMapping("/application/emailid/{emailid}")
	public Application deleteApplicationByEmailId(@PathVariable("emailid")String emailId) {
		if(appService.deleteApplicationByEmailId(emailId) == null) {
			throw new ApplicationNotFoundException("Application not found with given emailid: "+emailId);
		}
		
		return appService.deleteApplicationByEmailId(emailId);
	
	}
}




