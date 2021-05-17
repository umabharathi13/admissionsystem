package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.repository.IProgramRepository;
import com.cg.admissionsystem.service.ProgramService;


@ExtendWith(SpringExtension.class)
class ProgramMockitoTest {

		@InjectMocks
		ProgramService ps;
		
		@MockBean
		IProgramRepository iprep;
		
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}
		
		@Test
		void testAddProgram(){
			Program p=new Program(102,"IOT","3 months","B.Tech","Internet Of things","PG","Onprocess");
			Mockito.when(iprep.save(p)).thenReturn(p);
			Program program=ps.addProgram(p);
			assertEquals(102,program.getProgramId());
		}
		@Test
		void testviewProgramDetails() {
			Program p=new Program(101,"ML","3 months","B.E","Machine","UG","Completed");
			Program p1=new Program(102,"IOT","3 months","B.Tech","Internet Of things","PG","Onprocess");
			List<Program> pgmlist=new ArrayList<>();
			pgmlist.add(p);
			pgmlist.add(p1);
			Mockito.when(iprep.findAll()).thenReturn(pgmlist);
			List<Program> pgmm=ps.viewAllProgramDetails();
			assertEquals(2,pgmm.size());
		}
		
		@Test
		void testgetProgramById() {
			Program p=new Program(103,"IOT","3 months","B.Tech","Internet Of things","PG","Onprocess");
			Mockito.when(iprep.findById(103)).thenReturn(Optional.of(p));
			assertEquals(103,p.getProgramId());
		}
		@Test

		void testDeleteApplicationById() {
		Program p=new Program(102,"IOT","3 months","B.Tech","Internet Of things","PG","Onprocess");
			Mockito.when(iprep.findById(102)).thenReturn(Optional.of(p));
			iprep.deleteById(102);
			assertEquals(102,p.getProgramId());
		}
		
		@Test 
		void testupdateProgramStatus() {
			Program p=new Program(102,"IOT","3 months","B.Tech","Internet Of things","PG","Onprocess");
			p.setProgramId(102);
			p.setProgramStatus("Onprocess");
			Mockito.when(iprep.findById(102)).thenReturn(Optional.of(p));
			Mockito.when(iprep.save(p)).thenReturn(p);
			assertEquals("Onprocess",p.getProgramStatus());
		}
		@Test
		void testgetProgramDetailsByName() {
			Program p=new Program(102,"IOT","3 months","B.Tech","Internet Of things","PG","Onprocess");
			List<Program> pgm1=new ArrayList<>();
			pgm1.add(p);
			Mockito.when(iprep.findByProgramName("IOT")).thenReturn((pgm1));
			List<Program> pg = ps.findByProgramName("IOT");
			assertEquals(1,pg.size());			
		}
		
		@Test
	 void testgetProgramDetailsByEligibility() {
			Program p=new Program(102,"IOT","3 months","B.Tech","Internet Of things","PG","Onprocess");
			List<Program> pgm1=new ArrayList<>();
			pgm1.add(p);
			Mockito.when(iprep.findByProgramEligibility("PG")).thenReturn((pgm1));
			List<Program> pg = ps.findByProgramEligibility("PG");
			assertEquals(1,pg.size());	
		}
		
		@Test
		void testdeleteProgramByName() {
			Program p=new Program(102,"IOT","3 months","B.Tech","Internet Of things","PG","Onprocess");
			List<Program> pgm1=new ArrayList<>();
			pgm1.add(p);
			Mockito.when(iprep.findByProgramName("IOT")).thenReturn(pgm1);
			List<Program> pg = ps.findByProgramName("IOT");
			iprep.deleteProgramByProgramName("IOT");
		}
		
}
		
		



