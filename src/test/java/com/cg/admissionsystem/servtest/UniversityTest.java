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

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.service.IUniversityService;

@SpringBootTest
public class UniversityTest {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(UniversityTest.class);
	@Autowired
	IUniversityService universityService;

	/**
	 * testing whether values present in database or not
	 */
	@Test
	@Disabled

	void testfindAll() {
		List<University> university = universityService.findAll();
		for (University university1 : university) {
			logger.info(university1);
			logger.info("logger added to findAll");
		}
	}

	/*
	 * getting entry based on id
	 */
	@Test
	@Disabled

	void testFindUniversityById() {
		University university = universityService.getByUniversityId(101);
		assertEquals(101, university.getUniversityId());
	}

	/**
	 * adding values to the database
	 */
	@Test
	@Disabled

      void testCreateUniversity() {

		Branch branch = new Branch(117, "IT", "Information Technology");
		Branch branch1 = new Branch(118, "HRM", "Human Resource Management");
		List<Branch> branch2 = Stream.of(branch, branch1).collect(Collectors.toList());
		Course course = new Course(10, "MBA", "Master Of Business and Administration", "PG", branch2);
		Branch branch3 = new Branch(119, "IT", "Information Technology");
		Branch branch4 = new Branch(120, "HRM", "Human Resource Management");
		List<Branch> branch5 = Stream.of(branch3, branch4).collect(Collectors.toList());
		Course course1 = new Course(1, "M-TECH", "Master Of Technology", "PG", branch5);
		List<Course> course2 = Stream.of(course, course1).collect(Collectors.toList());
		Address address = new Address(5, "chennai", "indian", "chennai", "opp busstand", "tamilnadu", "635109");
		College college = new College(99, "GCET", course2);
		University university = new University(101, "Anna University", address, college);
		University university1 = universityService.save(university);
		assertEquals(101, university1.getUniversityId());
	}

	/**
	 * updating the values
	 */
	@Test
	@Disabled

	void updateUniversityTest() {
		University university = new University();
		university.setUniversityId(15);
		university.setName("svci");

		University university1 = universityService.updateUniversity(university);
		assertEquals(15, university1.getUniversityId());
	}

	/**
	 * deleting values by using id
	 */
	@Test
	@Disabled

	void deleteUniversityTest() {
		universityService.deleteUniversityById(122);
		logger.info("Deleted succefully");
	}

	/*
	 * get college details using college name
	 */
	@Test
	@Disabled

	void findbycollegenametest() {
		List<University> university = universityService.findByCollegeName("GCET");
		logger.info(university);
	}

}
