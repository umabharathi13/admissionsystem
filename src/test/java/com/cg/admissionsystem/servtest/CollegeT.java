package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.service.ICollegeService;
import com.cg.admissionsystem.service.IUniversityService;

@SpringBootTest
public class CollegeT {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(CollegeT.class);
	@Autowired
	ICollegeService collegeService;

	/*
	 * add the entries to the database
	 */
	@Test
	@Disabled

	void testAddCollege() {
		Address address = new Address(10, "chennai", "indian", "chennai", "opp busstand", "tamilnadu", "635109");
		Address address1 = new Address(65, "Mumbai", "indian", "Mumbai", "opp busstand", "tamilnadu", "635109");
		Program program1 = new Program(612, "ML", "2 years", "B.S.C", "MAchined learning", "12th", "Completed");
		List<Program> program = new ArrayList<>();
		program.add(program1);
		Branch branch1 = new Branch(716, "IT", "Information Technology");
		Branch branch2 = new Branch(891, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(branch1, branch2).collect(Collectors.toList());
		Course course = new Course(183, "MBA", "Master Of Business and Administration", "PG", branch);
		Branch branch3 = new Branch(130, "IT", "Information Technology");
		Branch branch4 = new Branch(528, "HRM", "Human Resource Management");
		List<Branch> branch5 = Stream.of(branch3, branch4).collect(Collectors.toList());
		Course course1 = new Course(513, "M-TECH", "Master Of Technology", "UG", branch5);
		List<Course> course2 = new ArrayList<>();
		course2.add(course);
		course2.add(course1);
		Address address3 = new Address(640, "Salem", "indian", "salem", "opp busstand", "tamilnadu", "635009");
		College college = new College(655, "IUYT", address3);
		University university = new University(2036, "Anna University", address3, college);
		College college1 = new College(3654, "OIUHT", address, program, course2, university);
		College college2 = collegeService.save(college);
		logger.info(college2);
		logger.info("Added college Details successfully");
		assertEquals(3654, college1.getCollegeRegId());
	}

	/*
	 * testing whether values present in database or not
	 */
	@Test
	@Disabled

	void testFindAll() {
		List<College> college = collegeService.findAll();
		for (College college1 : college) {
			logger.info(college1);
		}
	}

	/*
	 * getting entry based on id
	 */
	@Test
	@Disabled

	void testGetByCollegeRegId() {
		College college = collegeService.getCollegeByCollegeRegId(23);
		logger.info(college);
		logger.info("Get the values By Id");
		assertEquals(23, college.getCollegeRegId());
	}
	/*
	 * delete the entry using id
	 */

	@Test
	 @Disabled

	void testDeleteCollegeRegId() {
		College college = collegeService.deleteCollegeByCollegeRegId(18);

		logger.info(college);
		logger.info("deleted college by Id");

		assertEquals(18, college.getCollegeRegId());
	}

	/*
	 * get the entry by using name
	 */
	@Test
	@Disabled

	void testFindByName() {
		College college = collegeService.findByCollegeName("Cmr");

		logger.info(college);
		logger.info("Find college By Name");
		assertEquals("Cmr", college.getCollegeName());
	}

	/*
	 * update the entry by using name
	 */
	@Test
	@Disabled

	void testUpdateCollegeName() {
		College college = new College();
		college.setCollegeRegId(99);
		college.setCollegeName("vagdevi");
		College college1 = collegeService.updateCollegeName(18, college);

		logger.info(college1);
		logger.info("update college By college name");
		assertEquals(99, college1.getCollegeRegId());

	}

}
