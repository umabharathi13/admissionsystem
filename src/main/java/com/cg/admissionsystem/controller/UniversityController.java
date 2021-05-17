package com.cg.admissionsystem.controller;

import java.util.ArrayList;
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

import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.exception.CourseNotFoundException;
import com.cg.admissionsystem.exception.UniversityNotFoundException;
import com.cg.admissionsystem.service.IUniversityService;

@RestController
public class UniversityController {
	
	@Autowired
	IUniversityService unser;
	
	@PostMapping("/university")
	public University addUniversity(@RequestBody University university) {
		return unser.save(university);
	}
	@GetMapping("/university")
	public List<University> findAll() {
		return unser.findAll();
	}
	
	@DeleteMapping("/university/did/{id}")
	public University deleteUniversityId(@PathVariable("id") int universityId) {
		if(unser.deleteUniversityById(universityId)==null) {
		throw new UniversityNotFoundException("U can't delete because University not found for id:" +universityId);
	}
		return unser.deleteUniversityById(universityId);
	}
	@GetMapping("/university/id/{id}")
	public University getUniversityById(@PathVariable("id") int universityId) {
		if(unser.getByUniversityId(universityId)== null) {
			throw new UniversityNotFoundException("University not found for id:"+universityId);
		}
		return unser.getByUniversityId(universityId);
	}
	@PatchMapping("/university/{id}") 
	public University update(@PathVariable("id") int id, @RequestBody University university) {
		return unser.update(university);
	}
	
	@GetMapping("/course/collegename/{c}")
	public List<University> findBycollegeName(@PathVariable("c") String collegeName)  {
		if(unser.findBycollegeName(collegeName)== null) {
			throw new UniversityNotFoundException("University not found for collegename:"+collegeName);
		}
		return unser.findBycollegeName(collegeName);
	}
	
	
}
	
	
	

	