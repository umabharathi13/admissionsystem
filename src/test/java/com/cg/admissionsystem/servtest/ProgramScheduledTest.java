package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.module.ProgramScheduled;
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.service.IProgramScheduledService;

@SpringBootTest
class ProgramScheduledTest {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(ProgramScheduledTest.class);

	@Autowired
	IProgramScheduledService ipgmser;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setup");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	/**
	 * Test case for the method adding the program schedule to the database
	 */
	@Test
	@Disabled
	void testAddProgramSchedule() {
		Address a = new Address(10, "PUE", "MUSTRIAL", "Mune", "opp tand", "Mastra", "63565");
		Program pgm = new Program(114, "MLI", "2 years", "B.S.C", "Mchine", "UG", "Process");
		Branch b = new Branch(185, "ECE", "Electricals Com");
		Course course = new Course(66, "ME", "Master in Engineering", "PG");
		University university = new University("KKK university", 1066);
		College col = new College(5022, "JAIN", a);
		ProgramScheduled psch = new ProgramScheduled(255, "2018-05-07", "2019-11-27", "Full time", pgm, course, b,
				university, col);
		ProgramScheduled psh = ipgmser.addProgramSchedule(psch);
		logger.info(psh);
		logger.info("Added Successfully");
		assertEquals(255, psh.getScheduleId());
	}

	/**
	 * Test case for the method getting all the Program schedule in the form of list
	 */
	@Test
	// @Disabled
	void testViewAllProgramScheduleDetails() {
		List<ProgramScheduled> view = ipgmser.viewAllProgramScheduleDetails();
		for (ProgramScheduled p : view) {
			logger.info(p);
			logger.info("Getting all details");
		}
	}

	/**
	 * Test case for the method getting the program schedule by using scheduleId
	 */
	@Test
	// @Disabled
	void testGetProgramScheduleById() {
		ProgramScheduled view = ipgmser.getProgramScheduleById(102);
		logger.info(view);
		logger.info("Fetched details by id");
		assertEquals(102, view.getScheduleId());
	}

	/**
	 * Test case for the method deleting the program schedule by using scheduleId
	 */
	@Test
	@Disabled
	void testDeleteProgramScheduleById() {
		ProgramScheduled view = ipgmser.deleteProgramScheduleById(111);
		logger.info(view);
		logger.info("Removed by Id");
		assertEquals(111, view.getScheduleId());
	}

	/**
	 * Test case for the method updating the program schedule details
	 */
	@Test
	@Disabled
	void testUpdateProgramSchedule() {
		ProgramScheduled pgms = new ProgramScheduled();
		pgms.setScheduleId(102);
		pgms.setProgramSchedule("Full time");
		pgms.setStartDate("2016-06-15");
		pgms.setEndDate(" 2016-06-15");

		ProgramScheduled view = ipgmser.updateProgramSchedule(102, pgms);
		logger.info(view);
		logger.info("Updated program schedule");
		assertEquals(102, view.getScheduleId());
	}

	/**
	 * Test case for the method getting the program schedule by using start date
	 */
	@Test
	// @Disabled
	void testGetProgramScheduleByStartDate() {
		List<ProgramScheduled> view = ipgmser.findByStartDate("2016-03-14");
		for (ProgramScheduled p : view) {
			logger.info(p);
			logger.info("Fetched details by date");
		}
	}

	/**
	 * Test case for the method getting the program schedule by using college name
	 */
	@Test
	@Transactional
	// @Disabled
	void testGetBycollegeName() {
		List<ProgramScheduled> p = ipgmser.findByCollegeName("AIBS");
		for (ProgramScheduled p1 : p) {
			logger.info(p1);
			logger.info("Fetched details by college name");
		}
		assertEquals(1, p.size());
	}
}
