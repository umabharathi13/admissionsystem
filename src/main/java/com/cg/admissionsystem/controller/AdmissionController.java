package com.cg.admissionsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.module.Admission;
import com.cg.admissionsystem.service.IAdmissionService;

@RestController
public class AdmissionController {
	/**
	 * Logger
	 */
	
	org.apache.logging.log4j.Logger logger =LogManager.getLogger(AdmissionController.class);


	/**
	 * AutoWiring the service class to call down the service
	 */

	@Autowired
	IAdmissionService admi;

	/**
	 * This below function is used to create a new admission and redirects to the
	 * admission service
	 */

	@PostMapping("/admission")
	public ResponseEntity<Admission> addAdmission(@Valid @RequestBody Admission admission) {
		admi.save(admission);
		logger.info("adding values");
		return ResponseEntity.ok(admission);
	}

	/**
	 * This below function is used to get all the admission and redirects to the
	 * admission service
	 */

	@GetMapping("/admission")
	public ResponseEntity<List<Admission>> viewAllAdmissionDetails() {
		logger.info("getting all admission values");
		List<Admission> admission=admi.viewAll();
		return ResponseEntity.ok().body(admission);
	}
}
