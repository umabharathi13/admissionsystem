package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.checkerframework.checker.units.qual.degrees;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.module.ProgramScheduled;
import com.cg.admissionsystem.service.IProgramService;
import com.cg.admissionsystem.service.ProgramService;

@SpringBootTest
class ProgramTest {
	
	@Autowired
	IProgramService pgmser;

	@BeforeEach
	void setup() throws Exception {
		System.out.println("setup");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	@Test
	@Disabled
	void testaddProgram() {
		ProgramScheduled psch=new ProgramScheduled(119,"2016-03-14","2016-06-15","Full time");
		Program pgm = new Program(120,"iit","7 months","B.EE","Intelligence it","PG","Onprocess");
		psch.setProgram(pgm);
		pgm.setProgramScheduled(psch);
		Program pg = pgmser.addProgram(pgm);
		System.out.println(pg);
		assertEquals("iit", pg.getProgramName());
	}
	
	
	@Test
	@Disabled
	void testviewProgramDetails() {
		List<Program>view=pgmser.viewAllProgramDetails();
		for(Program p : view) {
			System.out.println(p);	
		}
	}
	
	@Test
	@Disabled
    void testgetProgramById() {
		Program view=pgmser.getProgramById(117);
		System.out.println(view);
		System.out.println("got");
	    assertEquals(117,view.getProgramId());
    }
	
	@Test
	@Disabled
    void testdeleteProgramById() {
		Program view=pgmser.deleteProgramById(120);
		System.out.println(view);
	    System.out.println("removed");
	    assertEquals(120,view.getProgramId());
    }
	

	@Test
	@Disabled
	void testgetProgramDetailsByEligibility() {
		List<Program> view=pgmser.findByProgramEligibility("UG");
		for(Program p:view) {
			System.out.println(p);
		}
	}
	
	@Test
	@Disabled
	void testgetProgramDetailsByName() {
		List<Program> view=pgmser.findByProgramName("iot");
		for(Program p:view) {
			System.out.println(p);
		}
	}
	
	@Test
	@Disabled
	void testupdateProgramStatus() {
 		Program p= new Program();
 		p.setProgramId(117);
 		p.setProgramStatus("ON Process");
 		Program view=pgmser.updateProgramStatus(117,p);
 		System.out.println(view);
      assertEquals(117,view.getProgramId());
         }
	
	@Test
	@Disabled
	void testdeleteProgramByName() {
		List<Program> view=pgmser.deleteProgramByProgramName("iit");
		System.out.println(view);
	    System.out.println("removed");
	    assertEquals("iit",((Program) view).getProgramName());
	}
	
	@Test
	@Disabled
	void testgetBycollegeName() {
		List<Program> p=pgmser.findByCollegeName("DRR");
		for(Program p1:p) {
			System.out.println(p1);
		}
		assertEquals(1,p.size());
	}
}
