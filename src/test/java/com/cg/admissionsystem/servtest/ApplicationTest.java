package com.cg.admissionsystem.servtest;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
   
	@Test
	@Disabled
	void testaddapplication() {
		LocalDate app1=LocalDate.of(1999,12,25);
		LocalDate app2=LocalDate.of(2020,10,25);		
		Address a=new Address(5,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
		Address a1=new Address(6,"trichy","indian","trichy","opp busstand","tamilnadu","635109");
		Program pgm = new Program(114,"IOT","3 years","B.S","Internet","12th","Completed");
		Branch b=new Branch(181,"EEE","Electricals");
		Course course=new Course(6,"MBA","Master of business administration","PG");
		College col=new College(5001,"AIMS",a);
		University university=new University(1001,"Anna university",a1,col);	
		ProgramScheduled psch=new ProgramScheduled(101,"2017-04-16","2017-12-28","Part time",pgm,course,b,university,col);
		Application a7=new Application(6,"Arun",app1,"B.E",75,"Engineer","eve@gmail.com","Rejected",app2,"Bad",psch);
		Application app=appser.addApplication(a7);
		assertEquals(6,app.getApplicationId());
		
}
	@Test
	@Disabled
	void testviewapplication() {
		List<Application>view=appser.viewAllApplicationDetails();
		for(Application a : view) {
			System.out.println(a);
			
		}

	}	
		
	@Test
	@Disabled
	void testgetApplicationById() {
 		Application view=appser.getApplicationById(1);
 	    System.out.println(view);
 	    assertEquals(1,view.getApplicationId());
 	    assertEquals("Matthew",view.getApplicantFullName());
 	} 
	
	@Test
	@Disabled
	void testgetapplicationbyemail() {
		Application view=appser.findByEmailId("matthew@gmail.com");
	    	System.out.println(view);
	    	assertEquals("Matthew",view.getApplicantFullName());
	    
	}
	
	@Test
	@Disabled
	void testgetApplicationDetailsByStatus() {
 		List<Application> view=appser.findByApplicationStatus("Accepted");
 	    System.out.println(view);
 	    assertEquals(2,view.size());	
 	}
	
	@Test
	@Disabled
	void testupdateApplicationStatus() {
		Application app = new Application();
		app.setApplicationId(5);
		app.setApplicationStatus("Accepted");
		Application view = appser.updateApplicationStatus(5, app);
		System.out.println(app);
		System.out.println("APPLICATIONSTATUS UPDATED");
		assertEquals(5, view.getApplicationId());
	}
     
	@Test
	@Disabled
	  void testDeleteApplicationById() {
 		Application view=appser.deleteApplicationById(2);
 	    System.out.println("REMOVED BY ID");
 	    assertEquals(2,view.getApplicationId());
 	    assertEquals("Adam",view.getApplicantFullName());

     }
	
    @Test	
    @Disabled
	void testDeleteApplicationByEmail() {
		Application app = new Application();
		Application view = appser.deleteApplicationByEmailId("monica@gmail.com");
		System.out.println("REMOVED BY EMAILID");
		assertEquals("monica@gmail.com", view.getEmailId());
	}
}