package com.cg.admissionsystem.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.ProgramScheduled;
import com.cg.admissionsystem.repository.IProgramScheduledRepositoy;

@Service
public class ProgramScheduledService implements IProgramScheduledService{
	
	@Autowired
	IProgramScheduledRepositoy pgrep;

	@Override
	public ProgramScheduled addProgramSchedule(ProgramScheduled programScheduled) {
		return pgrep.save(programScheduled);
	}

	@Override
	public List<ProgramScheduled> viewAllProgramScheduleDetails() {
		return pgrep.findAll();
	}

	@Override
	public ProgramScheduled getProgramScheduleById(int scheduleId) {
		Optional<ProgramScheduled> psc=pgrep.findById(scheduleId);
		if(!psc.isPresent()) {
			return null;
		}
		return psc.get();
	}

	@Override
	public ProgramScheduled deleteProgramScheduleById(int scheduleId) {
		Optional<ProgramScheduled> psc=pgrep.findById(scheduleId);
		if(!psc.isPresent()) {
			return psc.orElseThrow();
		}
		pgrep.deleteById(scheduleId);
		return psc.get();
	}

	@Override
	public ProgramScheduled updateProgramSchedule(int  scheduledId,ProgramScheduled programSchedule) {
		Optional<ProgramScheduled> pg=pgrep.findById(programSchedule.getScheduleId());
		if(!pg.isPresent()) {
			return null;
		}
			pg.get().setProgramSchedule(programSchedule.getProgramSchedule());
			pg.get().setStartDate(programSchedule.getStartDate());
			pg.get().setEndDate(programSchedule.getEndDate());		
		return pgrep.save(pg.get());
	}

	@Override
	public List<ProgramScheduled> findByStartDate(String startDate) {		
		List<ProgramScheduled> pgm=pgrep.findByStartDate(startDate);{
			if(pgm.isEmpty()) {
				return null;
			}
		}
		return pgrep.findByStartDate(startDate);
	}

	@Override
	public List<ProgramScheduled> findByCollegeName(String collegeName) {
		return pgrep.findBycollegeName(collegeName);
	}

}
