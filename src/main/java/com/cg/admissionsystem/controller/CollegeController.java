package com.cg.admissionsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.cg.admissionsystem.service.ICollegeService;

@RestController
public class CollegeController {
	
	@Autowired
	ICollegeService coser;
	
	@PostMapping("/college")
	public College addCollege(@RequestBody College college) {
		return coser.save(college);
	}
	
	@GetMapping("/college")
	public List<College> findAllCourse() {
		return coser.findAll();
	}
	
	@GetMapping("/college/id/{id}")
	public College getCollegeById(@PathVariable("id") int collegeId) {
		if(coser.getByCoId(collegeId)== null) {
			throw new CollegeNotFoundException("College not found for id:"+collegeId);
		}
		return coser.getByCoId(collegeId);
	}
	
	@DeleteMapping("/college/did/{id}")
	public College deleteCollege(@PathVariable("id") int collegeId) {
		if(coser.deleteByCollegeId(collegeId) == null) {
			throw new CollegeNotFoundException("U can't delete because College not found for id:" +collegeId);
		}
		return coser.deleteByCollegeId(collegeId);
	}
	
	@GetMapping("/college/colname/{clname}")
	public College findBycollegeName(@PathVariable("clname") String collegeName)  {
		if(coser.findBycollegeName(collegeName)== null) {
			throw new CollegeNotFoundException("College not found for collegename:"+collegeName);
		}
		return coser.findBycollegeName(collegeName);
	}
	
	@DeleteMapping("/college/dname/{name}")
	public void deleteCollegeByCollegeName(@PathVariable("name") String collegeName) {
		coser.deleteCollegeByCollegeName(collegeName);
	}
	
	@PatchMapping("/college/cid/{id}")
	public College updateCoName(@PathVariable("id") int collegeId, @RequestBody College college) {
		if(coser.getByCoId(collegeId)== null) {
			throw new CollegeNotFoundException("U can't update because College not found for id:"+collegeId);
		}
		return coser.updateC(collegeId,college);
	}
	/*
	@GetMapping("/college/coname/{coname}")
	public College findBycouName(@PathVariable("coname") String courseName)  {
		if(coser.findBycouName(courseName)== null) {
			throw new CollegeNotFoundException("College not found for coursename:"+courseName);
		}
		return coser.findBycouName(courseName);
	}
	
	*/
	
	
	
	

}
