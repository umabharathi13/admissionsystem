package com.cg.admissionsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.exception.CourseNotFoundException;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.service.ICourseService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CourseController {

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CourseController.class);

	/**
	 * AutoWiring the course service layer to this controller layer of course
	 * 
	 * @param CourseServiceImpl
	 */
	@Autowired
	ICourseService crser;

	/**
	 * This below function is used to create a new course and redirects to the
	 * CourseService
	 * 
	 * @param Course
	 * @return
	 */

	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		logger.info("Adding Course Details");
		crser.save(course);
		return crser.save(course);
	}

	/**
	 * The below functions are used to get all courses and get course for given
	 * ID,given courseName,given eligibilty and redirects to the CourseService
	 * 
	 * @exception CourseNotFoundException
	 * @param Course
	 * @return
	 */

	@GetMapping("/course")
	public List<Course> findAllCourse() {
		logger.info("Getting all Courses");
		return crser.findAll();
	}

	@GetMapping("/course/id/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") int courseId) {
		if (crser.getByCourseId(courseId) == null) {
			throw new CourseNotFoundException("Course not found for id:" + courseId);
		}
		logger.info("Getting Course for the given courseId:" + courseId);
		Course course = crser.getByCourseId(courseId);
		return ResponseEntity.ok().body(course);
	}

	@GetMapping("/course/cname/{crname}")
	public ResponseEntity<Course> findByName(@PathVariable("crname") String courseName) {
		if (crser.findByName(courseName) == null) {
			throw new CourseNotFoundException("Course not found for id:" + courseName);
		}
		logger.info("Getting Course for the given courseName:" + courseName);
		Course course = crser.findByName(courseName);
		return ResponseEntity.ok().body(course);
	}

	@GetMapping("/course/elig/{eligibility}")
	public ResponseEntity<List<Course>> findByEligibility(@PathVariable("eligibility") String eligibility) {
		if (crser.findByEligibility(eligibility) == null) {
			throw new CourseNotFoundException("Course not found for eligibility:" + eligibility);
		}
		logger.info("Getting Course for the given eligibility:" + eligibility);
		List<Course> course = crser.findByEligibility(eligibility);
		return ResponseEntity.ok().body(course);
	}

	/**
	 * The below functions are used to delete course by given ID.given courseName
	 * and redirects to the CourseService
	 * 
	 * @exception CourseNotFoundException
	 * @param Course
	 * @return
	 */

	@DeleteMapping("/course/did/{id}")
	public Course deleteCourse(@PathVariable("id") int courseId) {
		if (crser.deleteByCourseId(courseId) == null) {
			throw new CourseNotFoundException("U can't delete because Course not found for id:" + courseId);
		}
		logger.info("Deleted Course for the given courseId:" + courseId);
		return crser.deleteByCourseId(courseId);
	}

	@DeleteMapping("/course/name/{name}")
	public void deleteCourseByCourseName(@PathVariable("name") String courseName) {
		crser.deleteCourseByCourseName(courseName);
		logger.info("Deleted Course for the given courseName:" + courseName);
	}

	/**
	 * This below function is used to update a specific course and if specific
	 * course's name(if needed) based on the given Id and redirects to the
	 * CourseService
	 * 
	 * @exception CourseNotFoundException
	 * @param course
	 * @return
	 */

	@PutMapping("/course/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") int courseId, @RequestBody Course course) {
		if (crser.getByCourseId(courseId) == null) {
			throw new CourseNotFoundException("U can't update because Course not found for id:" + courseId);
		}
		Course c = crser.updateCourse(course);
		logger.info("Updated Course for the given courseId:" + courseId);
		return ResponseEntity.ok(c);
	}

	@PatchMapping("/course/cid/{id}")
	public ResponseEntity<Course> updateCourseName(@PathVariable("id") int courseId, @RequestBody Course course) {
		if (crser.getByCourseId(courseId) == null) {
			throw new CourseNotFoundException("U can't update because Course not found for id:" + courseId);
		}
		Course c = crser.updateCourseName(courseId, course);
		logger.info("Updated CourseName for the given courseId:" + courseId);
		return ResponseEntity.ok(c);
	}

	/**
	 * The below functions are used to get all courses for the given collegeName and
	 * redirects to the CourseService
	 * 
	 * @exception CourseNotFoundException
	 * @param Course
	 * @return
	 */

	@GetMapping("/course/colname/{clname}")
	public ResponseEntity<String> findBycollegeName(@PathVariable("clname") String collegeName) {
		if (crser.findBycollegeName(collegeName) == null) {
			throw new CourseNotFoundException("Course not found for collegename:" + collegeName);
		}
		crser.findBycollegeName(collegeName);
		logger.info("Getting Course for the given collegeName:" + collegeName);
		return ResponseEntity.ok().body(collegeName);
	}

}
