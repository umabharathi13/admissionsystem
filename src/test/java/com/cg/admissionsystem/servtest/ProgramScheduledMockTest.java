package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.module.ProgramScheduled;
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.repository.IProgramScheduledRepositoy;
import com.cg.admissionsystem.service.ProgramScheduledService;


@ExtendWith(SpringExtension.class)
class ProgramScheduledMockTest {

	@InjectMocks
	ProgramScheduledService pss;
	
	@MockBean
	IProgramScheduledRepositoy ipsrep;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testaddProgramSchedule(){
		Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
		Address a1=new Address(6,"trichy","indian","trichy","opp busstand","tamilnadu","635109");
		Program pgm = new Program(114,"IOT","3 years","B.S","Internet","12th","Completed");
		Branch b=new Branch(181,"EEE","Electricals");
		Course course=new Course(6,"MBA","Master of business administration","PG");
		College col=new College(5001,"AIMS",a);
		University university=new University(1001,"Anna university",a1,col);	
		ProgramScheduled psch=new ProgramScheduled(101,"2017-04-16","2017-12-28","Part time",pgm,course,b,university,col);
		Mockito.when(ipsrep.save(psch)).thenReturn(psch);
		ProgramScheduled programScheduled=pss.addProgramSchedule(psch);
		assertEquals(111,programScheduled.getScheduleId());
	}
	@Test
	void testviewAllProgramScheduleDetails() {
		Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
		Address a1=new Address(6,"trichy","indian","trichy","opp busstand","tamilnadu","635109");
		Program pgm = new Program(114,"IOT","3 years","B.S","Internet","12th","Completed");
		Branch b=new Branch(181,"EEE","Electricals");
		Course course=new Course(6,"MBA","Master of business administration","PG");
		College col=new College(5001,"AIMS",a);
		University university=new University(1001,"Anna university",a1,col);	
		ProgramScheduled psch=new ProgramScheduled(101,"2017-04-16","2017-12-28","Part time",pgm,course,b,university,col);
		Address a2=new Address(7,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
		Address a3=new Address(8,"trichy","indian","trichy","opp busstand","tamilnadu","635109");
		Program p1 = new Program(116,"IOT","3 years","B.S","Internet","12th","Completed");
		Branch b1=new Branch(182,"EEE","Electricals");
		Course course1=new Course(9,"MBA","Master of business administration","PG");
		College col1=new College(5002,"AIMS",a2);
		University university1=new University(1002,"Anna university",a3,col1);	
		ProgramScheduled psch1=new ProgramScheduled(106,"2017-04-16","2017-12-28","Part time",p1,course1,b1,university1,col1);
		List<ProgramScheduled> pgmlist=new ArrayList<>();
		pgmlist.add(psch);
		pgmlist.add(psch1);
		Mockito.when(ipsrep.findAll()).thenReturn(pgmlist);
		List<ProgramScheduled> pgmm=pss.viewAllProgramScheduleDetails();
		assertEquals(2,pgmm.size());
	}
	
	@Test
	void testgetProgramScheduleById() {
		Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
		Address a1=new Address(6,"trichy","indian","trichy","opp busstand","tamilnadu","635109");
		Program pgm = new Program(114,"IOT","3 years","B.S","Internet","12th","Completed");
		Branch b=new Branch(181,"EEE","Electricals");
		Course course=new Course(6,"MBA","Master of business administration","PG");
		College col=new College(5001,"AIMS",a);
		University university=new University(1001,"Anna university",a1,col);	
		ProgramScheduled psch=new ProgramScheduled(101,"2017-04-16","2017-12-28","Part time",pgm,course,b,university,col);
		Mockito.when(ipsrep.findById(103)).thenReturn(Optional.of(psch));
		assertEquals(111,psch.getScheduleId());
	}
	@Test
	void testdeleteProgramScheduleById() {
		Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
		Address a1=new Address(6,"trichy","indian","trichy","opp busstand","tamilnadu","635109");
		Program pgm = new Program(114,"IOT","3 years","B.S","Internet","12th","Completed");
		Branch b=new Branch(181,"EEE","Electricals");
		Course course=new Course(6,"MBA","Master of business administration","PG");
		College col=new College(5001,"AIMS",a);
		University university=new University(1001,"Anna university",a1,col);	
		ProgramScheduled psch=new ProgramScheduled(101,"2017-04-16","2017-12-28","Part time",pgm,course,b,university,col);
		Mockito.when(ipsrep.findById(111)).thenReturn(Optional.of(psch));
		ipsrep.deleteById(111);
		assertEquals(111,psch.getScheduleId());
	}
	
	@Test 
	void testupdateProgramSchedule() {
		Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
		Address a1=new Address(6,"trichy","indian","trichy","opp busstand","tamilnadu","635109");
		Program pgm = new Program(114,"IOT","3 years","B.S","Internet","12th","Completed");
		Branch b=new Branch(181,"EEE","Electricals");
		Course course=new Course(6,"MBA","Master of business administration","PG");
		College col=new College(5001,"AIMS",a);
		University university=new University(1001,"Anna university",a1,col);	
		ProgramScheduled psch=new ProgramScheduled(101,"2017-04-16","2017-12-28","Part time",pgm,course,b,university,col);
		Mockito.when(ipsrep.findById(111)).thenReturn(Optional.of(psch));
		Mockito.when(ipsrep.save(psch)).thenReturn(psch);
		ProgramScheduled programScheduled=pss.updateProgramSchedule(111,psch);
		assertEquals("2017-04-16",programScheduled.getStartDate());
		assertEquals("2017-12-28",programScheduled.getEndDate());
		assertEquals("Part time",programScheduled.getProgramSchedule());
	}
	
	@Test
	void testgetProgramScheduleByStartDate() {
		Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
		Address a1=new Address(6,"trichy","indian","trichy","opp busstand","tamilnadu","635109");
		Program pgm = new Program(114,"IOT","3 years","B.S","Internet","12th","Completed");
		Branch b=new Branch(181,"EEE","Electricals");
		Course course=new Course(6,"MBA","Master of business administration","PG");
		College col=new College(5001,"AIMS",a);
		University university=new University(1001,"Anna university",a1,col);	
		ProgramScheduled psch=new ProgramScheduled(101,"2017-04-16","2017-12-28","Part time",pgm,course,b,university,col);
		List<ProgramScheduled> pgm1=new ArrayList<>();
		pgm1.add(psch);
		Mockito.when(ipsrep.findByStartDate("2017-04-16")).thenReturn((pgm1));
		List<ProgramScheduled> pg = pss.findByStartDate("2017-04-16");
		assertEquals(1,pg.size());			
	}	
	
}
