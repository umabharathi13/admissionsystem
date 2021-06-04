package com.cg.admissionsystem.service;

import java.util.List;
import com.cg.admissionsystem.module.Course;

public interface ICourseService {

	/**
	 * Method to be override by the implementing class
	 * 
	 */

	Course save(Course course);

	List<Course> findAll();

	Course getByCourseId(int courseId);

	Course deleteByCourseId(int courseId);

	Course updateCourse(Course course);

	Course findByName(String courseName);

	List<Course> findByEligibility(String eligibility);

	void deleteCourseByCourseName(String courseName);

	Course updateCourseName(int courseId, Course course);

	List<Course> findBycollegeName(String collegeName);

}
