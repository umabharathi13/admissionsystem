package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.service.ICourseService;

@SpringBootTest
class CourseT {

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CourseT.class);

	@Autowired
	ICourseService crser;

	// add a new course test
	@Test
	@Disabled
	void testaddCourse() {
		Course course = new Course();
		Branch b = new Branch(463, "kl", "Information Technology");
		Branch b1 = new Branch(464, "lk", "Human Resource Management");
		List<Branch> branch = Stream.of(b, b1).collect(Collectors.toList());
		course.setCourseId(5);
		course.setCourseName("JKK");
		course.setDescription("Bachelor of Commerce");
		course.setEligibility("UG");
		course.setBranch(branch);
		Course c1 = crser.save(course);
		logger.info(c1);
		logger.info("added successfully");
		assertEquals(5, c1.getCourseId());
	}

	// getting course by ID test
	@Test
	// @Disabled
	void testFindcourseById() {
		Course c = crser.getByCourseId(51);
		logger.info(c);
		logger.info("getting course for the given courseId");
		assertEquals("BE", c.getCourseName());
	}

	// view all courses
	@Test
	// @Disabled
	void testfindAll() {
		List<Course> c = crser.findAll();
		for (Course c1 : c) {
			System.out.println(c1);
		}
		logger.info(c);
		logger.info("getting all course");
		assertEquals(22, c.size());
	}

	// delete course by ID test
	@Test
	@Disabled
	void deleteCourseIdTest() {
		crser.deleteByCourseId(4);
		logger.info("deleted");
	}

	// updating course details by ID test
	@Test
	@Disabled
	void updateCourseTest() {
		Course c = new Course();
		c.setCourseId(980);
		c.setCourseName("BCOM");
		c.setDescription("Bachelor of Commerce");
		c.setEligibility("UG");
		Course c1 = crser.updateCourse(c);
		logger.info(c1);
		assertEquals("BCOM", c1.getCourseName());
	}

	// get course by courseName test
	@Test
	@Disabled
	void getdetByNameTest() {
		Course c = crser.findByName("MS");
		logger.info(c);
		assertEquals("MS", c.getCourseName());
	}

	// get course by eligibility test
	@Test
	@Disabled
	void getdetByEligiTest() {
		List<Course> c = crser.findByEligibility("PG");
		for (Course c1 : c) {
			logger.info(c1);
		}
		assertEquals(7, c.size());
	}

	// delete course by courseName test
	@Test
	@Disabled
	void deleteCourseNameTest() {
		crser.deleteCourseByCourseName("GJ");
		logger.info("deleted");
	}

	// get courses by collegeName test
	@Test
	@Disabled
	void getdetBycollegeNameTest() {
		List<Course> c = crser.findBycollegeName("ACGCET");
		for (Course c1 : c) {
			logger.info(c1);
		}
		assertEquals(2, c.size());
	}

}
