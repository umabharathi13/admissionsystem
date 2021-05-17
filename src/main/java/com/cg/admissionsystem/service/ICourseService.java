package com.cg.admissionsystem.service;

import java.util.List;

import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;

public interface ICourseService {

	Course save(Course course);

	List<Course> findAll();

	Course getByCId(int courseId);

	Course deleteByCourseId(int courseId);

	Course update(Course course);

	Course findByName(String courseName);

	List<Course> findByEligibility(String eligibility);

	void deleteCourseByCourseName(String courseName);
	//public Course deleteCourseByCourseName(String courseName);
	
	Course updateC(int courseId, Course course);

	List<Course> findBycollegeName(String collegeName);


}
