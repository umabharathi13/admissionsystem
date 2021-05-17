package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.repository.ICourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {
	
	@Autowired
	ICourseRepository crrep;

	@Override
	public Course save(Course course) {
		return crrep.save(course);
	}

	@Override
	public List<Course> findAll() {
		return crrep.findAll();
	}

	@Override
	public Course getByCId(int courseId) {
		Optional<Course> co = crrep.findById(courseId);
	    if(!co.isPresent()) {
	    	return null;
	    }
	    return co.get();
	}
	@Override
	public Course deleteByCourseId(int courseId) {
		Optional<Course> co=crrep.findById(courseId);
		if(!co.isPresent()) {
		return null;
		}
		crrep.deleteById(courseId);
		return co.get();
	}
	@Override
	public Course update(Course course) {
		Optional<Course> c = crrep.findById(course.getCourseId());
		if(!c.isPresent()) {
			return null;
		}
		c.get().setCourseId(course.getCourseId());
	    c.get().setCourseName(course.getCourseName());
	    c.get().setDescription(course.getDescription());
	    c.get().setEligibility(course.getEligibility());
	    c.get().setBranch(course.getBranch());
		return crrep.save(c.get());
	}
	@Override
	public Course findByName(String courseName) {
		Course c=crrep.findByName(courseName);
		if(c==null) {
			return null;
		}
		return crrep.findByName(courseName);
	}
	@Override
	public List<Course> findByEligibility(String eligibility) {
		List<Course> c=crrep.findByEligibility(eligibility);
		if(c.isEmpty()) {
			return null;
		}
		return crrep.findByEligibility(eligibility);
	}
	@Override
	public void deleteCourseByCourseName(String courseName) {
		Course co=crrep.findByName(courseName);
		int a=co.getCourseId();
		if(a!=0)
		crrep.deleteById(a);
	}
	//Patch
	@Override
	public Course updateC(int CourseId, Course course) {
		Optional<Course> c = crrep.findById(course.getCourseId());
		if(!c.isPresent()) {
			return null;
		}
		c.get().setCourseName(course.getCourseName());
		//c.get().setDescription(course.getDescription());
		//c.get().setEligibility(course.getEligibility());
		//c.get().setBranch(course.getBranch());
		return crrep.save(c.get());
	}

	@Override
	public List<Course> findBycollegeName(String collegeName) {
	     List<Course> c=crrep.findBycollegeName(collegeName);
	     if(c.isEmpty()) {
	    	 return null;
	     }
	     return crrep.findBycollegeName(collegeName);
	}
	

	
}
