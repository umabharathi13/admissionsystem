package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.ProgramScheduled;
import com.cg.admissionsystem.repository.IProgramScheduledRepositoy;

/**
 * 
 * @author Brindha
 *
 */
@Service
public class ProgramScheduledService implements IProgramScheduledService {

	/**
	 * Autowiring the service class to call down the service
	 */
	@Autowired
	IProgramScheduledRepositoy pgrep;

	/**
	 * Adding new program schedule in the list;
	 * 
	 * @return programschedule.
	 */
	@Override
	public ProgramScheduled addProgramSchedule(ProgramScheduled programScheduled) {
		return pgrep.save(programScheduled);
	}

	/**
	 * Displays List of programscheduled.
	 * 
	 * @return all programscheduled.
	 */
	@Override
	public List<ProgramScheduled> viewAllProgramScheduleDetails() {
		return pgrep.findAll();
	}

	/**
	 * 
	 * Fetching the programschedule by the given id.
	 * 
	 * @return the programschedule with the given id.
	 * @throws ProgramScheduleNotFoundException.
	 * 
	 */
	@Override
	public ProgramScheduled getProgramScheduleById(int scheduleId) {
		Optional<ProgramScheduled> psc = pgrep.findById(scheduleId);
		if (!psc.isPresent()) {
			return null;
		}
		return psc.get();
	}

	/**
	 * 
	 * Deleting the programschedule by the given ID
	 * 
	 * @return the programschedule with the given id.
	 * @throws ProgramScheduleNotFoundException.
	 * 
	 */
	@Override
	public ProgramScheduled deleteProgramScheduleById(int scheduleId) {
		Optional<ProgramScheduled> psc = pgrep.findById(scheduleId);
		if (!psc.isPresent()) {
			return psc.orElseThrow();
		}
		pgrep.deleteById(scheduleId);
		return psc.get();
	}

	/**
	 * 
	 * Updating the programschedule by the give id.
	 * 
	 * @return the programschedule with the given id.
	 * @throws ProgramScheduleNotFoundException.
	 * 
	 */
	@Override
	public ProgramScheduled updateProgramSchedule(int scheduledId, ProgramScheduled programSchedule) {
		Optional<ProgramScheduled> pg = pgrep.findById(programSchedule.getScheduleId());
		if (!pg.isPresent()) {
			return null;
		}
		pg.get().setProgramSchedule(programSchedule.getProgramSchedule());
		pg.get().setStartDate(programSchedule.getStartDate());
		pg.get().setEndDate(programSchedule.getEndDate());
		return pgrep.save(pg.get());
	}

	/**
	 * 
	 * Fetching the programschedule by the given Date.
	 * 
	 * @return the programschedule with the given id.
	 * @throws ProgramScheduleNotFoundException.
	 * 
	 */
	@Override
	public List<ProgramScheduled> findByStartDate(String startDate) {
		List<ProgramScheduled> pgm = pgrep.findByStartDate(startDate);
		{
			if (pgm.isEmpty()) {
				return null;
			}
		}
		return pgrep.findByStartDate(startDate);
	}

	/**
	 * 
	 * Fetching the programschedule by the given college name.
	 * 
	 * @return the programschedule with the given college name.
	 * @throws ProgramScheduleNotFoundException.
	 * 
	 */
	@Override
	public List<ProgramScheduled> findByCollegeName(String collegeName) {
		List<ProgramScheduled> pgm = pgrep.findBycollegeName(collegeName);
		{
			if (pgm.isEmpty()) {
				return null;
			}
		}
		return pgrep.findBycollegeName(collegeName);
	}

}
