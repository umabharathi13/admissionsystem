package com.cg.admissionsystem.controller;

import java.util.List;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.admissionsystem.exception.ApplicationNotFoundException;
import com.cg.admissionsystem.module.Application;
import com.cg.admissionsystem.service.IApplicationService;

/**
 * @author Sherein.J
 *
 */
@CrossOrigin
@RestController
public class ApplicationController {
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(ApplicationController.class);

	/**
	 * AutoWiring the service class to call down the service
	 */
	@Autowired
	IApplicationService appService;

	/**
	 * This below function is used to create a new application and redirects to the
	 * application service
	 * 
	 * @param
	 * @return
	 */
	@PostMapping("/application")
	public ResponseEntity<Application> addApplication(@Valid @RequestBody Application application) {
		logger.info("ApplicationDetails is added");
		return ResponseEntity.ok(appService.addApplication(application));

	}

	/**
	 * This below function is used to get all the application and redirects to the
	 * application service
	 * 
	 * @return
	 */
	@GetMapping("/application")
	public  List<Application> viewAllDetails() {
		logger.info("ApplicationDetails is viewed");
		return appService.viewAllApplicationDetails();
	}

	/**
	 * This below function is used to get a specific application by id and redirects
	 * to the application service
	 * 
	 * @param
	 * @return
	 * @exception ApplicationNotFoundException
	 */
	@GetMapping("/application/id/{id}")
	public ResponseEntity<Application> getApplicationById(@PathVariable("id") int applicationId) {
		logger.info("ApplicationDetails is viewed by ApplicationId");
		if (appService.getApplicationById(applicationId) == null) {
			throw new ApplicationNotFoundException("Application not found with given id: " + applicationId);
		}
		Application application = appService.getApplicationById(applicationId);
		return ResponseEntity.ok().body(application);
	}

	/**
	 * This below function is used to update a specific application based on the
	 * give Id and redirects to the application service
	 * 
	 * @param
	 * @return
	 * @exception ApplicationNotFoundException
	 */
	@PatchMapping("/application/{id}")
	public ResponseEntity<Application> updateApplicationStatus(@PathVariable("id") int id,
			@RequestBody Application application) {
		logger.info("ApplicationStatus is updated");
		if (appService.updateApplicationStatus(id, application) == null) {
			throw new ApplicationNotFoundException("Application not found with given id: " + application);
		}
		return ResponseEntity.ok().body(appService.updateApplicationStatus(id, application));
	}

	/**
	 * This below function is used to get a specific application by Email-id and
	 * redirects to the application service
	 * 
	 * @param
	 * @return
	 * @exception ApplicationNotFoundException
	 */
	@GetMapping("/application/emailid/{emailid}")
	public ResponseEntity<Application> findByEmailId(@PathVariable("emailid") String emailId) {
		logger.info("ApplicationDetails is viewed by EmailId");
		if (appService.findByEmailId(emailId) == null) {
			throw new ApplicationNotFoundException("Application not found with given emailid:" + emailId);
		}
		return ResponseEntity.ok().body(appService.findByEmailId(emailId));

	}

	/**
	 * This below function is used to get a specific application by
	 * applicationStatus and redirects to the application service
	 * 
	 * @param
	 * @return
	 * @exception ApplicationNotFoundException
	 */
	@GetMapping("/application/applicationstatus/{applicationstatus}")
	public ResponseEntity<List<Application>> findByApplicationStatus(
			@PathVariable("applicationstatus") String applicationStatus) {
		logger.info("ApplicationDetails is viewed by ApplicationStatus");
		if (appService.findByApplicationStatus(applicationStatus) == null) {
			throw new ApplicationNotFoundException(
					"Application not found with given applicationStatus:" + applicationStatus);
		}
		return ResponseEntity.ok().body(appService.findByApplicationStatus(applicationStatus));
	}

	/**
	 * This below function is used to delete a specific application based on the
	 * given Id and redirects to the application service
	 * 
	 * @param
	 * @return
	 * @exception ApplicationNotFoundException
	 */
	@DeleteMapping("/application/{id}")
	public ResponseEntity<Application> deleteApplicationById(@PathVariable("id") int applicationId) {
		logger.info("ApplicationDetails is Deleted");
		if (appService.deleteApplicationById(applicationId) == null) {
			throw new ApplicationNotFoundException("Application not found with given id: " + applicationId);
		}
		return ResponseEntity.ok().body(appService.deleteApplicationById(applicationId));
	}

}
