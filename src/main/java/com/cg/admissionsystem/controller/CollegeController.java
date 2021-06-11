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

import com.cg.admissionsystem.exception.CollegeNotFoundException;
import com.cg.admissionsystem.exception.CourseNotFoundException;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.service.ICollegeService;
@CrossOrigin
@RestController
public class CollegeController {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CollegeController.class);
	@Autowired
	ICollegeService collegeService;

	/*
	 * This below function is used to create a new college and redirects to the
	 * college service
	 */
	@PostMapping("/college")
	public ResponseEntity<College> addCollege(@Valid @RequestBody College college) {
		logger.info("add college details");
		collegeService.save(college);
		return ResponseEntity.ok(college);
	}

	/*
	 * This below function is used to find the details of the college and redirects
	 * to the college service
	 */

	@GetMapping("/college")
	public List<College> findAll() {
		logger.info("find the cousrse by college");
		return collegeService.findAll();

	}
	/*
	 * This below function is used to get the college using the id and redirects to
	 * the college service
	 */

	@GetMapping("/college/id/{id}")
	public ResponseEntity<College> getCollegeByCollegeRegId(@PathVariable("id") int collegeRegId) {
		if (collegeService.getCollegeByCollegeRegId(collegeRegId) == null) {
			throw new CollegeNotFoundException("College not found for id:" + collegeRegId);
		}
		logger.info("get college details by college Id");
		College college = collegeService.getCollegeByCollegeRegId(collegeRegId);
		return ResponseEntity.ok(college);
	}

	/*
	 * This below function is used to delete the college using the id and redirects
	 * to the college service
	 */
	@DeleteMapping("/college/did/{id}")
	public ResponseEntity<College> deleteCollegeByCollegeRegId(@PathVariable("id") int collegeRegId) {
		if (collegeService.deleteCollegeByCollegeRegId(collegeRegId) == null) {
			throw new CollegeNotFoundException("U can't delete because College not found for id:" + collegeRegId);
		}
		logger.info("Delete college details by id");
		College college = collegeService.deleteCollegeByCollegeRegId(collegeRegId);
		return ResponseEntity.ok(college);
	}

	/*
	 * This below function is used to get the college using the name and redirects
	 * to the college service
	 */
	@GetMapping("/college/colname/{clname}")
	public ResponseEntity<College> findByCollegeName(@PathVariable("clname") String collegeName) {
		if (collegeService.findByCollegeName(collegeName) == null) {
			throw new CollegeNotFoundException("College not found for collegename:" + collegeName);
		}
		logger.info("find college details by college name");
		College college = collegeService.findByCollegeName(collegeName);
		return ResponseEntity.ok(college);
	}

	/*
	 * This below function is used to delete the program using the name and
	 * redirects to the college service
	 */
	@DeleteMapping("/college/dname/{name}")
	public void deleteCollegeByCollegeName(@PathVariable("name") String collegeName) {
		if (collegeService.findByCollegeName(collegeName) == null) {
			throw new CollegeNotFoundException("U can't update because College not found for id:" + collegeName);
		}
		logger.info("Delete college details by name");
		collegeService.deleteCollegeByCollegeName(collegeName);

	}
	/*
	 * This below function is used to update the college using the id and redirects
	 * to the college service
	 */

	@PatchMapping("/college/cid/{id}")
	public ResponseEntity<College> updateCollegeName(@PathVariable("id") int collegeRegId, @RequestBody College college) {
		if (collegeService.getCollegeByCollegeRegId(collegeRegId) == null) {
			throw new CollegeNotFoundException("U can't update because College not found for id:" + collegeRegId);
		}
		logger.info("update college details by name");
		College college1 = collegeService.updateCollegeName(collegeRegId, college);
		return ResponseEntity.ok(college1);
	}

}
