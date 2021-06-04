package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.module.Application;
import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.module.ProgramScheduled;
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.service.IApplicationService;

@SpringBootTest
class ApplicationTest {
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(ApplicationTest.class);

	@Autowired
	IApplicationService appser;

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setup");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	/**
	 * TestCase for the method adding the application to the database
	 */
	@Test
//	@Disabled
	void testAddApplication() {
		LocalDate app1 = LocalDate.of(1999, 12, 25);
		LocalDate app2 = LocalDate.of(2020, 10, 25);
		Address a = new Address(20, "madurai", "india", "chennai", "opp busstand", "tamilnadu", "635109");
		Address a1 = new Address(30, "trichy", "india", "trichy", "opp busstand", "tamilnadu", "635120");
		Program pgm = new Program(116, "AI", "3 years", "B.S", "Internet", "12th", "Completed");
		Branch b = new Branch(190, "ECE", "Electronics");
		Course course = new Course(50, "MBA", "Master of business administration", "PG");
		College col = new College(6000, "AIMS", a);
		University university = new University(2000, "Anna university", a1, col);
		ProgramScheduled psch = new ProgramScheduled(202, "2017-04-18", "2017-12-25", "Part time", pgm, course, b,
				university, col);
		Application a7 = new Application(10, "Andrew", app1, "B.E", 92, "Engineer", "andrew@gmail.com", "Accepted",
				app2, "Good", psch);
		Application app = appser.addApplication(a7);
		logger.info(app);
		logger.info("ApplicationDetails Added successfully");
		assertEquals(10, app.getApplicationId());

	}

	/**
	 * TestCase for the method getting all the applicationDetails in the form of
	 * list
	 */
	@Test
	@Disabled
	void testViewApplication() {
		List<Application> view = appser.viewAllApplicationDetails();
		for (Application a : view) {
			logger.info(a);

		}

	}

	/**
	 * TestCase for the method getting the applicationDetails by using applicationId
	 */
	@Test
	@Disabled
	void testGetApplicationById() {
		Application view = appser.getApplicationById(6);
		logger.info(view);
		logger.info("ApplicationDetails viewed successfully by ApplicationId");
		assertEquals(6, view.getApplicationId());
		assertEquals("Eve", view.getApplicantFullName());
	}

	/**
	 * TestCase for the method getting the applicationDetails by using emailId
	 */
	@Test
	@Disabled
	void testGetapplicationbyEmail() {
		Application view = appser.findByEmailId("eve@gmail.com");
		logger.info(view);
		logger.info("ApplicationDetails viewed successfully by EmailId");
		assertEquals("Eve", view.getApplicantFullName());

	}

	/**
	 * TestCase for the method getting the applicationDetails by using
	 * applicationStatus
	 */
	@Test
	@Disabled
	void testGetApplicationDetailsByStatus() {
		List<Application> view = appser.findByApplicationStatus("Rejected");
		logger.info(view);
		logger.info("ApplicationDetails viewed successfully by ApplicationStatus");
		assertEquals(1, view.size());
	}

	/**
	 * TestCase for the method updating applicationStatus
	 */
	@Test
	@Disabled
	void testUpdateApplicationStatus() {
		Application app = new Application();
		app.setApplicationId(6);
		app.setApplicationStatus("Accepted");
		Application view = appser.updateApplicationStatus(6, app);
		logger.info(app);
		logger.info("ApplicationStatus is Updated Successfully ");
		assertEquals(6, view.getApplicationId());
	}

	/**
	 * TestCase for the method deleting the applicationDetails by using
	 * applicationId
	 */
	@Test
	@Disabled
	void testDeleteApplicationById() {
		Application view = appser.deleteApplicationById(7);
		logger.info("Application is Deleted Successfully");
		assertEquals(7, view.getApplicationId());
		assertEquals("Arun", view.getApplicantFullName());

	}

}