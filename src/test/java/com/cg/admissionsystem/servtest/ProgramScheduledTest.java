package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;

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
	
	@Autowired
	IProgramScheduledService ipgmser;

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
	void testaddProgramSchedule() {
		Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
		Program pgm = new Program(114,"IOT","3 years","B.S","Internet","12th","Completed");
		Branch b=new Branch(181,"EEE","Electricals");
		Course course=new Course(6,"MBA","Master of business administration","PG");
		University university=new University("Anna university",1001);
		College col=new College(5001,"AIMS",a);	
		ProgramScheduled psch=new ProgramScheduled(101,"2017-04-16","2017-12-28","Part time",pgm,course,b,university,col);
		ProgramScheduled psh=ipgmser.addProgramSchedule(psch);
		System.out.println(psh);
		System.out.println("Added Successfully");
		assertEquals(101, psh.getScheduleId());
	}
	
	@Test
	@Disabled
	void testviewAllProgramScheduleDetails() {
		List<ProgramScheduled> view = ipgmser.viewAllProgramScheduleDetails();
		for (ProgramScheduled p : view) {
			System.out.println(p);
		}
	}

	@Test
	@Disabled
    void testgetProgramScheduleById() {
		ProgramScheduled view=ipgmser.getProgramScheduleById(115);
		System.out.println(view);
		System.out.println("got");
	    assertEquals(115,view.getScheduleId());
    }

	@Test
	@Disabled
    void testdeleteProgramScheduleById() {
		ProgramScheduled view=ipgmser.deleteProgramScheduleById(111);
		System.out.println(view);
	    System.out.println("removed");
	    assertEquals(111,view.getScheduleId());
	      }

	@Test
	@Disabled
	void testupdateProgramSchedule() {
		ProgramScheduled pgms = new ProgramScheduled();
		pgms.setScheduleId(110);
		pgms.setProgramSchedule("Part time");
		pgms.setStartDate(" 2015-10-12");
		pgms.setEndDate(" 2016-11-15");
		
		ProgramScheduled view=ipgmser.updateProgramSchedule(110,pgms);
		System.out.println(view);
		System.out.println("Program Schedule updated");
		assertEquals(110,view.getScheduleId());
	}

	@Test
	@Disabled
	void testgetProgramScheduleByStartDate() {
		List<ProgramScheduled> view = ipgmser.findByStartDate("2015-03-12");
		for (ProgramScheduled p : view) {
			System.out.println(p);
		}
	}
	@Test
	@Transactional
	@Disabled
	void testgetBycollegeName() {
		List<ProgramScheduled> p=ipgmser.findByCollegeName("DRS");
		for(ProgramScheduled p1:p) {
			System.out.println(p1);
		}
		assertEquals(1,p.size());
	}
}
