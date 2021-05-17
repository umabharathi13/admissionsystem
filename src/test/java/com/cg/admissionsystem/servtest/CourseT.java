package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.service.ICourseService;

@SpringBootTest
class CourseT {
	
	@Autowired
	ICourseService crser;

	@Test
	@Disabled
	void testaddCourse() {
		Course course=new Course();
		Branch b=new Branch(117,"IT","Information Technology");
		Branch b1=new Branch(118,"HRM","Human Resource Management");
		List<Branch> branch=Stream.of(b,b1).collect(Collectors.toList());
		course.setCourseId(6);
		course.setCourseName("MBA");
		course.setDescription("Master Of Business and Administration");
		course.setEligibility("PG");
		course.setBranch(branch);
		Course c1=crser.save(course);
		assertEquals(6,course.getCourseId());
	}
	@Test
	//@Disabled
	void testFindcourseById() {
		Course c=crser.getByCId(1);
		assertEquals("BE",c.getCourseName());
	}
	@Test
	//@Disabled
	void testfindAll() {
		List<Course> c= crser.findAll();
		for(Course c1:c) {
			System.out.println(c1);
		}
		assertEquals(2,c.size());
	}
	@Test
	@Disabled
	void deleteCourseIdTest() {
		Course c=crser.deleteByCourseId(5);
		System.out.println("deleted");
	}
	@Test
	@Disabled
	void updateCourseTest() {
		Course c=new Course();
		c.setCourseId(4);
		c.setCourseName("M-TECH");
		c.setDescription("Master Of Technology");
		c.setEligibility("PG");
		Course c1=crser.update(c);
		assertEquals("M-TECH",c1.getCourseName());
	}
	@Test
	//@Disabled
	void getdetByNameTest() {
		Course c=crser.findByName("BE");
		assertEquals(1,c.getCourseId());
	}
	@Test
	//@Disabled
	void getdetByEligiTest() {
		List<Course> c=crser.findByEligibility("UG");
		for(Course c1:c) {
			System.out.println(c1);
		}
		assertEquals(2,c.size());
	}
	@Test
    @Disabled
	void deleteCourseNameTest() {
	    crser.deleteCourseByCourseName("MBA");
		System.out.println("deleted");
		}
	@Test
	@Disabled
	void getdetBycollegeNameTest() {
		List<Course> c=crser.findBycollegeName("ACGCET");
		for(Course c1:c) {
			System.out.println(c1);
		}
		assertEquals(2,c.size());
	}
	
	
}
