package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.repository.IProgramRepository;

@Service
public class ProgramService implements IProgramService {

	@Autowired
	IProgramRepository pgmrepo;

	@Override
	public Program addProgram(Program program) {
		return pgmrepo.save(program);
	}

	@Override
	public List<Program> viewAllProgramDetails() {
		return pgmrepo.findAll();
	}

	@Override
	public Program getProgramById(int programId) {
		Optional<Program> pgm = pgmrepo.findById(programId);
		if (!pgm.isPresent()) {
			return null;
		}
		return pgm.get();
	}

	@Override
	public Program deleteProgramById(int programId) {
		Optional<Program> pgm = pgmrepo.findById(programId);
		if (!pgm.isPresent()) {
			return null;
		}
		pgmrepo.deleteById(programId);
		return pgm.get();
	}

	@Override
	public List<Program> findByProgramName(String programName) {
		List<Program> p=pgmrepo.findByProgramName(programName);
		if (p.isEmpty()) {
			return null;
		}
		return pgmrepo.findByProgramName(programName);
	}

	@Override
	public List<Program> findByProgramEligibility(String programEligibility) {
		List<Program> p=pgmrepo.findByProgramEligibility(programEligibility);
		if (p.isEmpty()) {
			return null;
		}
		return pgmrepo.findByProgramEligibility(programEligibility);
	}

	@Override
	public Program updateProgramStatus(int pgmid, Program program) {
		Optional<Program> pgm = pgmrepo.findById(program.getProgramId());
		if (!pgm.isPresent()) {
			return null;
		}
		pgm.get().setProgramStatus(program.getProgramStatus());
		return pgmrepo.save(pgm.get());
	}

	@Override
	public  List<Program> deleteProgramByProgramName(String programName) {
		List<Program> pgm = pgmrepo.findByProgramName(programName);
		if (pgm.isEmpty()) {
			return null;
		}
		 return pgmrepo.deleteProgramByProgramName(programName);
	}

	@Override
	public List<Program> findByCollegeName(String collegeName) {
		return pgmrepo.findBycollegeName(collegeName);
	}

}
