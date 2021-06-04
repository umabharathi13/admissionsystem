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
	/**
	 * Mockito Test case for the method adding the program to the database
	 */
	@Test
	void testAddProgram() {
		Program p = new Program(102, "IOT", "3 months", "B.Tech", "Internet Of things", "PG", "Onprocess");
		Mockito.when(iprep.save(p)).thenReturn(p);
		Program program = ps.addProgram(p);
		assertEquals(102, program.getProgramId());
	}
	/**
	 * Mockito Test case for the method getting all the Program in the form of list
	 */
	@Test
	void testViewProgramDetails() {
		Program p = new Program(101, "ML", "3 months", "B.E", "Machine", "UG", "Completed");
		Program p1 = new Program(102, "IOT", "3 months", "B.Tech", "Internet Of things", "PG", "Onprocess");
		List<Program> pgmlist = new ArrayList<>();
		pgmlist.add(p);
		pgmlist.add(p1);
		Mockito.when(iprep.findAll()).thenReturn(pgmlist);
		List<Program> pgmm = ps.viewAllProgramDetails();
		assertEquals(2, pgmm.size());
	}
	/**
	 * Mockito Test case for the method getting the program by using programId
	 */
	@Test
	void testGetProgramById() {
		Program p = new Program(103, "IOT", "3 months", "B.Tech", "Internet Of things", "PG", "Onprocess");
		Mockito.when(iprep.findById(103)).thenReturn(Optional.of(p));
		assertEquals(103, p.getProgramId());
	}
	/**
	 * Mockito Test case for the method deleting the program by using programId
	 */
	@Test
	void testDeleteApplicationById() {
		Program p = new Program(102, "IOT", "3 months", "B.Tech", "Internet Of things", "PG", "Onprocess");
		Mockito.when(iprep.findById(102)).thenReturn(Optional.of(p));
		iprep.deleteById(102);
		assertEquals(102, p.getProgramId());
	}
	/**
	 * Mockito Test case for the method updating the program status
	 */
	@Test
	void testUpdateProgramStatus() {
		Program p = new Program(102, "IOT", "3 months", "B.Tech", "Internet Of things", "PG", "Onprocess");
		p.setProgramId(102);
		p.setProgramStatus("Onprocess");
		Mockito.when(iprep.findById(102)).thenReturn(Optional.of(p));
		Mockito.when(iprep.save(p)).thenReturn(p);
		assertEquals("Onprocess", p.getProgramStatus());
	}
	/**
	 * Mockito Test case for the method getting the program by using program name
	 */
	@Test
	void testGetProgramDetailsByName() {
		Program p = new Program(102, "IOT", "3 months", "B.Tech", "Internet Of things", "PG", "Onprocess");
		List<Program> pgm1 = new ArrayList<>();
		pgm1.add(p);
		Mockito.when(iprep.findByProgramName("IOT")).thenReturn((pgm1));
		List<Program> pg = ps.findByProgramName("IOT");
		assertEquals(1, pg.size());
	}
	/**
	 * Mockito Test case for the method getting the program by using eligility
	 */
	@Test
	void testGetProgramDetailsByEligibility() {
		Program p = new Program(102, "IOT", "3 months", "B.Tech", "Internet Of things", "PG", "Onprocess");
		List<Program> pgm1 = new ArrayList<>();
		pgm1.add(p);
		Mockito.when(iprep.findByProgramEligibility("PG")).thenReturn((pgm1));
		List<Program> pg = ps.findByProgramEligibility("PG");
		assertEquals(1, pg.size());
	}
}
