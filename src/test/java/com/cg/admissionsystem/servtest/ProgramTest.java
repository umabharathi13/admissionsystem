package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.module.ProgramScheduled;
import com.cg.admissionsystem.service.IProgramService;
import com.cg.admissionsystem.service.ProgramService;

@SpringBootTest
class ProgramTest {
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(ProgramTest.class);

	@Autowired
	IProgramService pgmser;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setup");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	/**
	 * Test case for the method adding the program to the database
	 */
	@Test
	@Disabled
	void testAddProgram() {
		ProgramScheduled psch = new ProgramScheduled(524, "2017-04-05", "2018-08-18", "Full time");
		Program pgm = new Program(522, "ML", "8 months", "B.EE", "MAchine it", "UG", "Onprocess");
		psch.setProgram(pgm);
		pgm.setProgramScheduled(psch);
		Program pg = pgmser.addProgram(pgm);
		logger.info(pg);
		logger.info("Added details successfully");
		assertEquals("ML", pg.getProgramName());
	}

	/**
	 * Test case for the method getting all the Program in the form of list
	 */
	@Test
	@Disabled
	void testViewProgramDetails() {
		List<Program> view = pgmser.viewAllProgramDetails();
		for (Program p : view) {
			logger.info("Getting all Details");
			logger.info(p);

		}
	}

	/**
	 * Test case for the method getting the program by using programId
	 */
	@Test
	@Disabled
	void testGetProgramById() {
		Program view = pgmser.getProgramById(111);
		logger.info(view);
		logger.info("fetched details by id");
		assertEquals(111, view.getProgramId());
	}

	/**
	 * Test case for the method deleting the program by using programId
	 */
	@Test
	@Disabled
	void testDeleteProgramById() {
		Program view = pgmser.deleteProgramById(154);
		logger.info(view);
		logger.info("Deleted program details by id");
		assertEquals(154, view.getProgramId());
	}

	/**
	 * Test case for the method getting the program by using eligility
	 */
	@Test
	@Disabled
	void testGetProgramDetailsByEligibility() {
		List<Program> view = pgmser.findByProgramEligibility("PG");
		for (Program p : view) {
			logger.info(p);
			logger.info("Fetched details");
		}
	}

	/**
	 * Test case for the method getting the program by using program name
	 */
	@Test
	@Disabled
	void testGetProgramDetailsByName() {
		List<Program> view = pgmser.findByProgramName("iit");
		for (Program p : view) {
			logger.info(p);
			logger.info("fetched details by name");
		}
	}

	/**
	 * Test case for the method updating the program status
	 */
	@Test
	//@Disabled
	void testUpdateProgramStatus() {
		Program p = new Program();
		p.setProgramId(111);
		p.setProgramStatus("On process");
		Program view = pgmser.updateProgramStatus(117, p);
		logger.info(view);
		logger.info("updated program by status");
		assertEquals(111, view.getProgramId());
	}

	/**
	 * Test case for the method getting the program by using college name
	 */
	@Test
	@Disabled
	void testGetBycollegeName() {
		List<Program> p = pgmser.findByCollegeName("OIUHT");
		for (Program p1 : p) {
			logger.info(p1);
			logger.info("fetched program details by college name");
		}
		assertEquals(1, p.size());
	}
}
