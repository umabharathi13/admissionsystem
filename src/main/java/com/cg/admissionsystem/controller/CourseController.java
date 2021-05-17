package com.cg.admissionsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.exception.CourseNotFoundException;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.service.ICourseService;

@RestController
public class CourseController {
	
	@Autowired
	ICourseService crser;
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		return crser.save(course);
	}
	
	@GetMapping("/course")
	public List<Course> findAllCourse() {
		return crser.findAll();
	}
	
	@GetMapping("/course/id/{id}")
	public Course getCourseById(@PathVariable("id") int courseId) {
		if(crser.getByCId(courseId)== null) {
			throw new CourseNotFoundException("Course not found for id:"+courseId);
		}
		return crser.getByCId(courseId);
	}
	
	@DeleteMapping("/course/did/{id}")
	public Course deleteCourse(@PathVariable("id") int courseId) {
		if(crser.deleteByCourseId(courseId) == null) {
			throw new CourseNotFoundException("U can't delete because Course not found for id:" +courseId);
		}
		return crser.deleteByCourseId(courseId);
	}
	
	@PutMapping("/course/{id}") 
	public Course updateBranch(@PathVariable("id") int courseId, @RequestBody Course course) {
		if(crser.getByCId(courseId)== null) {
			throw new CourseNotFoundException("U can't update because Course not found for id:"+courseId);
		}
		return crser.update(course);
	}
	
	@GetMapping("/course/cname/{crname}")
	public Course findByName(@PathVariable("crname") String courseName)  {
		if(crser.findByName(courseName)== null) {
			throw new CourseNotFoundException("Course not found for id:"+courseName);
		}
		return crser.findByName(courseName);
	}
	
	@GetMapping("/course/elig/{eligibility}")
	public List<Course> findByEligibility(@PathVariable("eligibility") String eligibility) {
		if(crser.findByEligibility(eligibility)== null) {
			throw new CourseNotFoundException("Course not found for eligibility:"+eligibility);
		}
		return crser.findByEligibility(eligibility);
	}
	/*
	@DeleteMapping("/course/name/{name}")
	public Course deleteCourseByCourseName(@PathVariable("name") String courseName) {
		if(crser.findByName(courseName)== null) {
			throw new CourseNotFoundException("U can't delete because Course not found for eligibility:"+courseName);
		}
		return crser.deleteCourseByCourseName(courseName);
	}
	*/
	@DeleteMapping("/course/name/{name}")
	public void deleteCourseByCourseName(@PathVariable("name") String courseName) {
		crser.deleteCourseByCourseName(courseName);
	}
	
	@PatchMapping("/course/cid/{id}")
	public Course updateCName(@PathVariable("id") int courseId, @RequestBody Course course) {
		if(crser.getByCId(courseId)== null) {
			throw new CourseNotFoundException("U can't update because Course not found for id:"+courseId);
		}
		return crser.updateC(courseId,course);
	}
	
	@GetMapping("/course/colname/{clname}")
	public List<Course> findBycollegeName(@PathVariable("clname") String collegeName)  {
		if(crser.findBycollegeName(collegeName)== null) {
			throw new CourseNotFoundException("Course not found for collegename:"+collegeName);
		}
		return crser.findBycollegeName(collegeName);
	}
	
	
	
	
	
	
}
