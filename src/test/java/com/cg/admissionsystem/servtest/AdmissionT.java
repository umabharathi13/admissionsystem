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
import com.cg.admissionsystem.module.Admission;
import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.service.IAdmissionService;

@SpringBootTest
class AdmissionT {
	org.apache.logging.log4j.Logger logger=LogManager.getLogger(AdmissionT.class);


	@Autowired
	IAdmissionService ad;

	@Test
	// @Disabled
	void addAdmission() {

		Program pgm = new Program(120, "iit", "7 months", "B.EE", "Intelligence it", "PG", "Onprocess");

		Branch b = new Branch(117, "IT", "Information Technology");
		Branch b1 = new Branch(118, "HRM", "Human Resource Management");
		List<Branch> branch = Stream.of(b, b1).collect(Collectors.toList());
		Course course = new Course(6, "MBA", "Master Of Business and Administration", "PG", branch);

		Address a = new Address(4, "salem", "indian", "salem", "opp busstand", "tamilnadu", "635108");

		College c = new College(12, "vit university", a);
		Admission add = new Admission(1, "usa@gmail.com", "pending", "2020", c, course, pgm);
		Admission a1 = ad.save(add);
		logger.info(a1);
		logger.info("added succesfully");
		assertEquals("2020", a1.getYear());

	}

	@Test
	@Disabled
	void viewAdmissionTest() {
		List<Admission> view = ad.viewAll();
		logger.info(view);
		logger.info("getting values");
		assertEquals(1, view.size());

	}

}
