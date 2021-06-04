package com.cg.admissionsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.exception.CourseNotFoundException;
import com.cg.admissionsystem.exception.ProgramNotFoundException;
import com.cg.admissionsystem.exception.ProgramScheduledNotFoundException;
import com.cg.admissionsystem.service.IProgramService;

/**
 * @author Brindha
 */
@CrossOrigin
@RestController
public class ProgramController {
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(ProgramController.class);

	/**
	 * Autowiring the service class to call down the service
	 */
	@Autowired
	IProgramService pgmService;

	/**
	 * This below function is used to create a new program and redirects to the
	 * program service
	 */
	@PostMapping("/program")
	public ResponseEntity<Program> addProgram(@Valid @RequestBody Program program) {
		logger.info("Adding Program Details");
		pgmService.addProgram(program);
		return ResponseEntity.ok(pgmService.addProgram(program));
	}

	/**
	 * This below function is used to get all the programs and redirects to the
	 * program service
	 */
	@GetMapping("/program")
	public ResponseEntity<List<Program>> viewAllProgramDetails() {
		logger.info("Getting all Program Details");
		return ResponseEntity.ok(pgmService.viewAllProgramDetails());
		 
	}

	/**
	 * This below function is used to get a specific program by id as parameter and
	 * redirects to the program service
	 * 
	 * @exception ProgramNotFoundException
	 */
	@GetMapping("/program/{programid}")
	public ResponseEntity<Program> GetProgramById(@PathVariable("programid") int programId) throws ProgramNotFoundException {
		if (pgmService.getProgramById(programId) == null) {
			throw new ProgramNotFoundException("Program not found with give ID:" + programId);
		}
		logger.info("Getting Program Details By Id");
		Program program=pgmService.getProgramById(programId);
		return ResponseEntity.ok().body(program);
	}

	/**
	 * This below function is used to delete a specific program based on the given
	 * Id and redirects to the program service
	 * 
	 * @exception PeogramNotFoundException
	 */

	@DeleteMapping("/program/delete/{programid}")
	public ResponseEntity<Program> DeleteProgramById(@PathVariable("programid") int programId) throws ProgramNotFoundException{
		if (pgmService.deleteProgramById(programId) == null) {
			throw new ProgramNotFoundException("Program not found with give ID:" + programId);
		}
		logger.info("Deleting Program by Id");
		return ResponseEntity.ok(pgmService.deleteProgramById(programId));
	}

	/**
	 * This below function is used to get a specific program name by id as parameter
	 * and redirects to the program service
	 * 
	 * @exception ProgramNotFoundException
	 */

	@GetMapping("/program/programname/{programname}")
	public ResponseEntity<List<Program>> findByProgramName(@PathVariable("programname") String programName) throws ProgramNotFoundException{
		if (pgmService.findByProgramName(programName) == null) {
			throw new ProgramNotFoundException("Program not found with given program name:" + programName);
		}
		logger.info("Getting Program Details by name");
		return ResponseEntity.ok().body(pgmService.findByProgramName(programName));
	}

	/**
	 * This below function is used to get a specific program eligibility by id as
	 * parameter and redirects to the program service
	 * 
	 * @exception ProgramNotFoundException
	 */

	@GetMapping("/program/programeligibility/{programeligibility}")
	public ResponseEntity<List<Program>> findByProgramEligibility(@PathVariable("programeligibility") String programEligibility) throws ProgramNotFoundException{
		if (pgmService.findByProgramEligibility(programEligibility) == null) {
			throw new ProgramNotFoundException(
					"Program not found with given program eligibility:" + programEligibility);
		}
		logger.info("Getting Program Details by eligibility");
		return ResponseEntity.ok().body(pgmService.findByProgramEligibility(programEligibility));
	}

	/**
	 * This below function is used to update a specific program status based on the
	 * give Id and redirects to the program service
	 * 
	 * @exception ProgramNotFoundException
	 */

	@PatchMapping("/program/update/{programid}")
	public  ResponseEntity<Program> updateProgramStatus(@PathVariable("programid") int pgmid, @RequestBody Program program) throws ProgramNotFoundException{
		if (pgmService.updateProgramStatus(pgmid, program) == null) {
			throw new ProgramNotFoundException("Program not found with give ID:" + pgmid);
		}
		logger.info("Updating  Program Status");
		return ResponseEntity.ok().body(pgmService.updateProgramStatus(pgmid, program));
	}

	/**
	 * This below function is used to get a specific program by college name as
	 * parameter and redirects to the program service
	 * 
	 * @exception ProgramNotFoundException
	 */

	@GetMapping("/program/colname/{clname}")
	public ResponseEntity<List<Program>> findByCollegeName(@PathVariable("clname") String collegeName) throws ProgramNotFoundException{
		if (pgmService.findByCollegeName(collegeName) == null) {
			throw new ProgramNotFoundException("Program not found for id:" + collegeName);
		}
		logger.info("Getting Program details by college name");
		return ResponseEntity.ok().body(pgmService.findByCollegeName(collegeName));
	}

}
