package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.repository.IProgramRepository;

/**
 * 
 * @author Brindha
 *
 */

@Service
public class ProgramService implements IProgramService {

	/**
	 * Autowiring the service class to call down the service
	 */
	@Autowired
	IProgramRepository pgmrepo;

	/**
	 * Adding new program in the list;
	 * 
	 * @return program.
	 */
	@Override
	public Program addProgram(Program program) {
		return pgmrepo.save(program);
	}

	/**
	 * Displays List of programs.
	 * 
	 * @return all programs.
	 */
	@Override
	public List<Program> viewAllProgramDetails() {
		return pgmrepo.findAll();
	}

	/**
	 * 
	 * Fetching the program by the given ID
	 * 
	 * @return the program with the given id.
	 * @throws ProgramNotFoundException.
	 * 
	 */

	@Override
	public Program getProgramById(int programId) {
		Optional<Program> pgm = pgmrepo.findById(programId);
		if (!pgm.isPresent()) {
			return null;
		}
		return pgm.get();
	}

	/**
	 * 
	 * Deleting the program by the given ID
	 * 
	 * @return the program with the given id.
	 * @throws ProgramNotFoundException.
	 * 
	 */
	@Override
	public Program deleteProgramById(int programId) {
		Optional<Program> pgm = pgmrepo.findById(programId);
		if (!pgm.isPresent()) {
			return null;
		}
		pgmrepo.deleteById(programId);
		return pgm.get();
	}

	/**
	 * 
	 * Fetching the program by the given name.
	 * 
	 * @return the program with the given name.
	 * @throws ProgramNotFoundException.
	 * 
	 */
	@Override
	public List<Program> findByProgramName(String programName) {
		List<Program> p = pgmrepo.findByProgramName(programName);
		if (p.isEmpty()) {
			return null;
		}
		return pgmrepo.findByProgramName(programName);
	}

	/**
	 * 
	 * Fetching the program by the given eligibility.
	 * 
	 * @return the program with the given id.
	 * @throws ProgramNotFoundException.
	 * 
	 */
	@Override
	public List<Program> findByProgramEligibility(String programEligibility) {
		List<Program> p = pgmrepo.findByProgramEligibility(programEligibility);
		if (p.isEmpty()) {
			return null;
		}
		return pgmrepo.findByProgramEligibility(programEligibility);
	}

	/**
	 * 
	 * Updating the program status by the given ID
	 * 
	 * @return the program with the given id.
	 * @throws ProgramNotFoundException.
	 * 
	 */
	@Override
	public Program updateProgramStatus(int pgmid, Program program) {
		Optional<Program> pgm = pgmrepo.findById(program.getProgramId());
		if (!pgm.isPresent()) {
			return null;
		}
		pgm.get().setProgramStatus(program.getProgramStatus());
		return pgmrepo.save(pgm.get());
	}

	/**
	 * 
	 * Fetching the program by the given college name.
	 * 
	 * @return the program with the given college name.
	 * @throws ProgramNotFoundException.
	 * 
	 */
	@Override
	public List<Program> findByCollegeName(String collegeName) {
		List<Program> p = pgmrepo.findBycollegeName(collegeName);
		if (p.isEmpty()) {
			return null;
		}
		return pgmrepo.findBycollegeName(collegeName);
	}

}
