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
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.exception.UniversityNotFoundException;
import com.cg.admissionsystem.service.IUniversityService;

@CrossOrigin
@RestController
public class UniversityController {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(UniversityController.class);
	// @Autowired can be used to bean on the setter method
	@Autowired
	IUniversityService universityService;

	/*
	 * This below function is used to create a new university and redirects to the
	 * university service
	 */
	@PostMapping("/university")
	public ResponseEntity<University> addUniversity(@Valid @RequestBody University university) {
		logger.info("add the details of the university");
		universityService.save(university);
		return ResponseEntity.ok(university);
	}
	/*
	 * This below function is used to get the details of the university and
	 * redirects to the university service
	 */

	@GetMapping("/university")
	public ResponseEntity<List<University>> findAll() {
		List<University> university = universityService.findAll();
		logger.info("Find the details of the university");
		return ResponseEntity.ok().body(university);
	}
	/*
	 * This below function is used to delete the university using the id and
	 * redirects to the university service
	 * 
	 */

	@DeleteMapping("/university/did/{id}")
	public ResponseEntity<University> deleteUniversityId(@PathVariable("id") int universityId) {
		if (universityService.deleteUniversityById(universityId) == null) {
			throw new UniversityNotFoundException("U can't delete because University not found for id:" + universityId);
		}
		logger.info("delete the University By Id");
		University university = universityService.deleteUniversityById(universityId);
		return ResponseEntity.ok(university);
	}

	/*
	 * This below function is used to get the university using the id and redirects
	 * to the university service
	 */
	@GetMapping("/university/id/{id}")
	public ResponseEntity<University> getUniversityById(@PathVariable("id") int universityId) {
		if (universityService.getByUniversityId(universityId) == null) {
			throw new UniversityNotFoundException("University not found for id:" + universityId);
		}
		logger.info("Get the university details By Id ");
		University university = universityService.getByUniversityId(universityId);
		return ResponseEntity.ok(university);
	}
	/*
	 * This below function is used to update the university using the id and
	 * redirects to the university service
	 */

	@PatchMapping("/university/{id}")
	public ResponseEntity<University> updateUniversity(@PathVariable("id") int id, @RequestBody University university) {
		if (universityService.updateUniversity(university) == null) {
			throw new UniversityNotFoundException("University not found for id:" + university);
		}
		logger.info("update the university details by id");
		University university1 = universityService.updateUniversity(university);
		return ResponseEntity.ok(university1);
	}

	/*
	 * This below function is used to find the university using the collegeName and
	 * redirects to the university service
	 */
	@GetMapping("/course/collegename/{c}")
	public List<University> findBycollegeName(@PathVariable("c") String collegeName) {
		if (universityService.findByCollegeName(collegeName) == null) {
			throw new UniversityNotFoundException("University not found for collegename:" + collegeName);
		}
		logger.info("Find college details by college name");

		return universityService.findByCollegeName(collegeName);
	}

}
