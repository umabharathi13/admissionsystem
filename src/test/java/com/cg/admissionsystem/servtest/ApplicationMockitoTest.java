package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.admissionsystem.module.Address;
import com.cg.admissionsystem.module.Application;
import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.College;
import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.module.ProgramScheduled;
import com.cg.admissionsystem.module.University;
import com.cg.admissionsystem.repository.IApplicationRepository;
import com.cg.admissionsystem.service.ApplicationServiceImpl;
@ExtendWith(SpringExtension.class)
class ApplicationMockitoTest {
	
	@InjectMocks
	ApplicationServiceImpl appService;
	
	@MockBean
	IApplicationRepository appRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
//	@Disabled
	void testAddApplication() {
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
		Mockito.when(appRepo.save(a7)).thenReturn(a7);
		Application app = appService.addApplication(a7);
		assertEquals(6, app.getApplicationId());
		
	}
	
	@Test
	@Disabled
	void testviewAllApplicationDetails() {
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
		Application application=new Application(6,"Arun",app1,"B.E",75,"Engineer","eve@gmail.com","Rejected",app2,"Bad",psch);
		
		LocalDate app3=LocalDate.of(1999,12,25);
		LocalDate app4=LocalDate.of(2020,10,25);		
		Address a3=new Address(10,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
		Address a4=new Address(9,"trichy","indian","trichy","opp busstand","tamilnadu","635109");
		Program pgm1 = new Program(119,"IOT","3 years","B.S","Internet","12th","Completed");
		Branch b1=new Branch(189,"EEE","Electricals");
		Course course1=new Course(9,"MBA","Master of business administration","PG");
		College col1=new College(5009,"AIMS",a4);
		University university1=new University(1002,"Anna university",a3,col);	
		ProgramScheduled psch1=new ProgramScheduled(102,"2017-04-16","2017-12-28","Part time",pgm1,course1,b1,university1,col1);
		Application application1=new Application(9,"Arun",app3,"B.E",75,"Engineer","eve@gmail.com","Rejected",app4,"Bad",psch1);

		List<Application> applicationList = new ArrayList<>();
		applicationList.add(application);
		applicationList.add(application1);

		Mockito.when(appRepo.findAll()).thenReturn(applicationList);

		List<Application> app = appService.viewAllApplicationDetails();

		assertEquals(2, app.size());

	}
	
	@Test
//	@Disabled
	void testGetApplicationById() {
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
		Application application=new Application(6,"Arun",app1,"B.E",75,"Engineer","eve@gmail.com","Rejected",app2,"Bad",psch);
		
		Mockito.when(appRepo.findById(6)).thenReturn(Optional.of(application));
		
		Application app = appService.getApplicationById(6);
		
		assertEquals(6, app.getApplicationId());
		
	}
	
	@Test
//	@Disabled
	void testFindByEmailId() {
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
		Application application=new Application(6,"Arun",app1,"B.E",75,"Engineer","eve@gmail.com","Rejected",app2,"Bad",psch);
		
		Mockito.when(appRepo.findByEmailId("eve@gmail.com")).thenReturn(application);
		
		Application app = appService.findByEmailId("eve@gmail.com");
		assertEquals("eve@gmail.com",app.getEmailId());
				
	}
	
	@Test
//	@Disabled
	void testFindByApplicationStatus() {
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
		Application application=new Application(6,"Arun",app1,"B.E",75,"Engineer","eve@gmail.com","Rejected",app2,"Bad",psch);
		
		LocalDate app3=LocalDate.of(1999,12,25);
		LocalDate app4=LocalDate.of(2020,10,25);		
		Address a3=new Address(10,"chennai","indian","chennai","opp busstand","tamilnadu","635109");
		Address a4=new Address(9,"trichy","indian","trichy","opp busstand","tamilnadu","635109");
		Program pgm1 = new Program(119,"IOT","3 years","B.S","Internet","12th","Completed");
		Branch b1=new Branch(189,"EEE","Electricals");
		Course course1=new Course(9,"MBA","Master of business administration","PG");
		College col1=new College(5009,"AIMS",a4);
		University university1=new University(1002,"Anna university",a3,col);	
		ProgramScheduled psch1=new ProgramScheduled(102,"2017-04-16","2017-12-28","Part time",pgm1,course1,b1,university1,col1);
		Application application1=new Application(9,"Arun",app3,"B.E",75,"Engineer","eve@gmail.com","Rejected",app4,"Bad",psch1);

		List<Application> applicationList = new ArrayList<>();
		applicationList.add(application);
		applicationList.add(application1);
		
		Mockito.when(appRepo.findByApplicationStatus("Rejected")).thenReturn(applicationList);	
		List<Application> app = appService.findByApplicationStatus("Rejected");
		assertEquals(2, app.size());
		
	}	
	
	@Test
	@Disabled
	void testUpdateApplicationStatus() {
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
		Application application=new Application(6,"Arun",app1,"B.E",75,"Engineer","eve@gmail.com","Rejected",app2,"Bad",psch);
		Mockito.when(appRepo.findById(6)).thenReturn(Optional.of(application));
		Mockito.when(appRepo.save(application)).thenReturn(application);
		
		Application view = appService.updateApplicationStatus(6, application);
		
		assertEquals("Rejected", view.getApplicationStatus());	
		
	}
	
	@Test
//	@Disabled
	void testDeleteApplicationById() {
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
		Application application=new Application(6,"Arun",app1,"B.E",75,"Engineer","eve@gmail.com","Rejected",app2,"Bad",psch);
	Mockito.when(appRepo.findById(6)).thenReturn(Optional.of(application));
	appRepo.deleteById(6);
	Application view = appService.deleteApplicationById(6);
	assertEquals(6,view.getApplicationId());
	
	}
	
	@Test
//	@Disabled
	void testDeleteApplicationByEmailIdId() {
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
		Application application=new Application(6,"Arun",app1,"B.E",75,"Engineer","eve@gmail.com","Rejected",app2,"Bad",psch);
		Mockito.when(appRepo.findByEmailId("eve@gmail.com")).thenReturn(application);
		appRepo.deleteApplicationByEmailId("eve@gmail.com");
		
	}
	
	
}
