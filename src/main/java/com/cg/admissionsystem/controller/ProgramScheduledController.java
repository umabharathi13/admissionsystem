package com.cg.admissionsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.module.Program;
import com.cg.admissionsystem.module.ProgramScheduled;
import com.cg.admissionsystem.exception.ProgramNotFoundException;
import com.cg.admissionsystem.exception.ProgramScheduledNotFoundException;
import com.cg.admissionsystem.service.IProgramScheduledService;

/**
 * @author Brindha
 */
@CrossOrigin
@RestController
public class ProgramScheduledController {
	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(ProgramScheduledController.class);

	/**
	 * Autowiring the service class to call down the service
	 */
	@Autowired
	IProgramScheduledService pgser;

	/**
	 * This below function is used to create a new programschedule and redirects to the
	 * programschedule service
	 */
	@PostMapping("/programscheduled")
	public ResponseEntity<ProgramScheduled> addProgramschedule(@RequestBody ProgramScheduled programScheduled) {
		logger.info("Adding Program scheduled Details");
		pgser.addProgramSchedule(programScheduled);
		return ResponseEntity.ok(pgser.addProgramSchedule(programScheduled));
	}

	/**
	 * This below function is used to get all the programschedule and redirects to the
	 * programschedule service
	 */
	@GetMapping("/programscheduled")
	public ResponseEntity<List<ProgramScheduled>> viewAllProgramScheduleDetails() {
		logger.info("Getting all Program scheduled details");
		return ResponseEntity.ok(pgser.viewAllProgramScheduleDetails());
	}

	/**
	 * This below function is used to get a specific programschedule by id as parameter and
	 * redirects to the programschedule service
	 * 
	 * @exception ProgramNotFoundException
	 */
	@GetMapping("/programscheduled/{scheduleid}")
	public ResponseEntity<ProgramScheduled> getProgramScheduleById(@PathVariable("scheduleid") int scheduleId) throws ProgramScheduledNotFoundException{
		if (pgser.getProgramScheduleById(scheduleId) == null) {
			throw new ProgramScheduledNotFoundException(" ProgramSchedule not found with give ID:" + scheduleId);
		}
		logger.info("Getting Details by Id");
		ProgramScheduled pgm=pgser.getProgramScheduleById(scheduleId);
		return ResponseEntity.ok().body(pgm);
	}

	/**
	 * This below function is used to delete a specific programschedule based on the given
	 * Id and redirects to the programschedule service
	 * 
	 * @exception ProgramscheduleNotFoundException
	 */
	@DeleteMapping("/programscheduled/scheduleid/{scheduleid}")
	public ResponseEntity<ProgramScheduled> DeleteProgramScheduleById(@PathVariable("scheduleid") int scheduleId) throws ProgramScheduledNotFoundException{
		if (pgser.deleteProgramScheduleById(scheduleId) == null) {
			throw new ProgramScheduledNotFoundException("ProgramSchedule not found with give ID:" + scheduleId);
		}
		logger.info("Deleting Program scheduled by ID");
		return ResponseEntity.ok(pgser.deleteProgramScheduleById(scheduleId));
	}

	/**
	 * This below function is used to update a programschedule based on the
	 * give Id and redirects to the programschedule service
	 * 
	 * @exception ProgramscheduleNotFoundException
	 */
	@PutMapping("/programscheduled/{scheduleid}")
	public ResponseEntity<ProgramScheduled> updateProgramSchedule(@PathVariable("scheduleid") int scheduleId,@RequestBody ProgramScheduled programScheduled) throws ProgramScheduledNotFoundException {
		if (pgser.updateProgramSchedule(scheduleId, programScheduled) == null) {
			throw new ProgramScheduledNotFoundException("ProgramSchedule not found with give ID:" + scheduleId);
		}
		logger.info("updating Program schedule Details");
		return ResponseEntity.ok().body(pgser.updateProgramSchedule(scheduleId, programScheduled));
	}

	/**
	 * This below function is used to get a specific programschedule date by id as parameter
	 * and redirects to the programschedule service
	 * 
	 * @exception ProgramscheduleNotFoundException
	 */
	@GetMapping("/programscheduled/startdate/{startdate}")
	public ResponseEntity<List<ProgramScheduled>> findByStartDate(@PathVariable("startdate") String startDate) throws ProgramScheduledNotFoundException{
		if (pgser.findByStartDate(startDate) == null) {
			throw new ProgramScheduledNotFoundException("ProgramSchedule not found with given Start Date:" + startDate);
		}
		logger.info("Getting Program scheduled by date");
		return ResponseEntity.ok().body(pgser.findByStartDate(startDate));
	}

	/**
	 * This below function is used to get a specific Programschedule by college name as
	 * parameter and redirects to the programschedule service
	 * 
	 * @exception ProgramscheduleNotFoundException
	 */
	@GetMapping("/programscheduled/colname/{clname}")
	public ResponseEntity<List<ProgramScheduled>> findBycollegeName(@PathVariable("clname") String collegeName) throws ProgramScheduledNotFoundException{
		if (pgser.findByCollegeName(collegeName) == null) {
			throw new ProgramScheduledNotFoundException("Program scheduled not found for id:" + collegeName);
		}
		logger.info("Getting Program scheduled details by college name");
		return  ResponseEntity.ok().body(pgser.findByCollegeName(collegeName));
	}

}
