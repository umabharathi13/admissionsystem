package com.cg.admissionsystem.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.exception.CourseNotFoundException;
import com.cg.admissionsystem.exception.ProgramNotFoundException;
import com.cg.admissionsystem.exception.ProgramScheduledNotFoundException;
import com.cg.admissionsystem.service.IProgramService;


@RestController
public class ProgramController {
	
	@Autowired
	IProgramService pgmService;
	
	@PostMapping("/program")
	public Program addProgram(@RequestBody Program program) {
		return pgmService.addProgram(program);		
	}
	
	@GetMapping("/program")
	public  List<Program>viewAllProgramDetails(){
		return pgmService.viewAllProgramDetails();
		}
		
	@GetMapping("/program/{programid}")
	public Program GetProgramById(@PathVariable("programid") int programId) {
		if(pgmService.getProgramById(programId)==null) {
			throw new ProgramNotFoundException("Program not found with give ID:"+programId);
		}
		return pgmService.getProgramById(programId);
	}
	

	@DeleteMapping("/program/{programid}")
	public Program DeleteProgramById(@PathVariable("programid") int programId) {
		if(pgmService.deleteProgramById(programId)==null) {
			throw new ProgramNotFoundException("Program not found with give ID:"+programId);
		}
		return pgmService.deleteProgramById(programId);
	}
	
	@GetMapping("/program/programname/{programname}")
	public List<Program> findByProgramName(@PathVariable("programname") String programName) {
		if(pgmService.findByProgramName(programName)==null) {
			throw new ProgramNotFoundException("Program not found with given program name:"+programName);
		}
		return pgmService.findByProgramName(programName);
	}

	@GetMapping("/program/programeligibility/{programeligibility}")
	public List<Program>findByProgramEligibility(@PathVariable("programeligibility") String programEligibility) {
		if(pgmService.findByProgramEligibility(programEligibility)==null) {
			throw new ProgramNotFoundException("Program not found with given program eligibility:"+programEligibility);
		}
		return pgmService.findByProgramEligibility(programEligibility);
	}
	
	@PatchMapping("/program/{programid}")
	public Program updateProgramStatus(@PathVariable("programid") int pgmid, @RequestBody Program program) {
		if(pgmService.updateProgramStatus(pgmid,program)==null) {
			throw new ProgramNotFoundException("Program not found with give ID:"+pgmid);
		}
		return pgmService.updateProgramStatus(pgmid, program);
	}
	
	@DeleteMapping("/program/programname/{programname}")
	public List<Program> deleteProgramByProgramName(@PathVariable("programname") String programName) {
		if(pgmService.deleteProgramByProgramName(programName)==null) {
			throw new ProgramNotFoundException("Program not found with given program name:"+programName);
		}
		return pgmService.deleteProgramByProgramName(programName);
	}
	
	@GetMapping("/program/colname/{clname}")
	public List<Program> findBycollegeName(@PathVariable("clname") String collegeName)  {
		if(pgmService.findByCollegeName(collegeName)== null) {
			throw new ProgramNotFoundException("Program not found for id:"+collegeName);
		}
		return pgmService.findByCollegeName(collegeName);
	}	
	
}
