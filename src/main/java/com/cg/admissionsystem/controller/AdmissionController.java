package com.cg.admissionsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.exception.AddressNotFoundException;
import com.cg.admissionsystem.exception.AdmissionNotFoundException;
import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.module.Admission;
import com.cg.admissionsystem.service.IAdmissionService;

@RestController
@CrossOrigin
@RequestMapping("/api")
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
	@GetMapping("/admission/{Id}")
	public ResponseEntity <Admission> getAdmissionById(@PathVariable("Id") int admissionId) {
		if (admi.getAdmissionById(admissionId) == null) {
			throw new AdmissionNotFoundException("Admission not found with given id: " + admissionId);
		}
		logger.info("getting admission by id"+admissionId);
		Admission admission=admi.getAdmissionById(admissionId);
		return ResponseEntity.ok().body(admission);
	}
	
	@PutMapping("/admission/{id}")
	public ResponseEntity<Admission> updateAdmission(@PathVariable("id") int admissionId, @RequestBody Admission admission) {
		if (admi.getAdmissionById(admissionId)==null) {
			throw new AdmissionNotFoundException("Admission not found with given name: " + admissionId);
		}
		logger.info("updating admission by id"+admissionId);
		Admission a=admi.updateAdmission(admission);
		return ResponseEntity.ok(admission);

	}
	@DeleteMapping("/admission/{Id}")
	public Admission deleteAdmission(@PathVariable("Id") int admissionId) {
		if (admi.getAdmissionById(admissionId) == null) {
			throw new AddressNotFoundException("Admission not found with given id: " + admissionId);
		}
		logger.info("deleting address by id"+admissionId);
		return admi.deleteAdmissionById(admissionId);
	}
}
