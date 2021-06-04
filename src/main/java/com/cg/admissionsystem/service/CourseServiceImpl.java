package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.repository.ICourseRepository;

/**
 * Course Service
 *
 */

@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	ICourseRepository crrep;

	/**
	 * Used to Store the Course passed as parameter from the Controller function
	 * 
	 * @param course
	 * @return
	 */
	@Override
	public Course save(Course course) {
		return crrep.save(course);
	}

	/**
	 * Get the list of all the Course
	 * 
	 * @return
	 */
	@Override
	public List<Course> findAll() {
		return crrep.findAll();
	}

	/**
	 * This function will retrieve the Course on basis of given Id exception
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Course getByCourseId(int courseId) {
		Optional<Course> co = crrep.findById(courseId);
		if (!co.isPresent()) {
			return null;
		}
		return co.get();
	}

	/**
	 * used to delete the Course based on the given ID
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Course deleteByCourseId(int courseId) {
		Optional<Course> co = crrep.findById(courseId);
		if (!co.isPresent()) {
			return null;
		}
		crrep.deleteById(courseId);
		return co.get();
	}

	/**
	 * Used to update Course on based on the given Id
	 * 
	 * @param id
	 * @param Course
	 * @return
	 */
	@Override
	public Course updateCourse(Course course) {
		Optional<Course> c = crrep.findById(course.getCourseId());
		if (!c.isPresent()) {
			return null;
		}
		c.get().setCourseId(course.getCourseId());
		c.get().setCourseName(course.getCourseName());
		c.get().setDescription(course.getDescription());
		c.get().setEligibility(course.getEligibility());
		c.get().setBranch(course.getBranch());
		return crrep.save(c.get());
	}

	/**
	 * This function will retrieve the Course on basis of given courseName
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Course findByName(String courseName) {
		Course c = crrep.findByName(courseName);
		if (c == null) {
			return null;
		}
		return crrep.findByName(courseName);
	}

	/**
	 * This function will retrieve the Course on basis of given eligibility
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public List<Course> findByEligibility(String eligibility) {
		List<Course> c = crrep.findByEligibility(eligibility);
		if (c.isEmpty()) {
			return null;
		}
		return crrep.findByEligibility(eligibility);
	}

	/**
	 * used to delete the Course based on the given courseName
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public void deleteCourseByCourseName(String courseName) {
		Course co = crrep.findByName(courseName);
		int a = co.getCourseId();
		if (a != 0)
			crrep.deleteById(a);
	}

	/**
	 * Used to update courseName on based on the given Id
	 * 
	 * @param id
	 * @param Course
	 * @return
	 */
	@Override
	public Course updateCourseName(int CourseId, Course course) {
		Optional<Course> c = crrep.findById(course.getCourseId());
		if (!c.isPresent()) {
			return null;
		}
		c.get().setCourseName(course.getCourseName());
		// c.get().setDescription(course.getDescription());
		// c.get().setEligibility(course.getEligibility());
		// c.get().setBranch(course.getBranch());
		return crrep.save(c.get());
	}

	/**
	 * This function will retrieve the Course on basis of given collegeName
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public List<Course> findBycollegeName(String collegeName) {
		List<Course> c = crrep.findBycollegeName(collegeName);
		if (c.isEmpty()) {
			return null;
		}
		return crrep.findBycollegeName(collegeName);
	}

}
