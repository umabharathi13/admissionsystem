package com.cg.admissionsystem.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

@RestController
public class ProgramScheduledController {
	
	@Autowired
	IProgramScheduledService pgser;
	
	@PostMapping("/programscheduled")
	public ProgramScheduled addProgramschedule(@RequestBody ProgramScheduled programScheduled) {
		return pgser.addProgramSchedule(programScheduled);
	}
	
	@GetMapping("/programscheduled")
	public List<ProgramScheduled> viewAllProgramScheduleDetails(){
		return pgser.viewAllProgramScheduleDetails();
		}
	
	@GetMapping("/programscheduled/{scheduleid}")
	public ProgramScheduled getProgramScheduleById(@PathVariable("scheduleid") int scheduleId) {
		if(pgser.getProgramScheduleById(scheduleId)==null) {
			throw new ProgramScheduledNotFoundException("ProgramSchedule not found with give ID:"+scheduleId);
		}
		return pgser.getProgramScheduleById(scheduleId);
	}
	
	@DeleteMapping("/programscheduled/scheduleid/{scheduleid}")
	public ProgramScheduled DeleteProgramScheduleById(@PathVariable("scheduleid") int scheduleId) {
		if(pgser.deleteProgramScheduleById(scheduleId)==null) {
			throw new ProgramScheduledNotFoundException("ProgramSchedule not found with give ID:"+scheduleId);
		}
		return pgser.deleteProgramScheduleById(scheduleId);
	}
	
	@PutMapping("/programscheduled/{scheduleid}")
	public ProgramScheduled updateProgramSchedule(@PathVariable("scheduleid") int scheduleId, @RequestBody ProgramScheduled programScheduled) {
		if(pgser.updateProgramSchedule(scheduleId,programScheduled)==null) {
			throw new ProgramScheduledNotFoundException("ProgramSchedule not found with give ID:"+scheduleId);
	}
		return pgser.updateProgramSchedule(scheduleId,programScheduled);
	}
	
	@GetMapping("/programscheduled/startdate/{startdate}")
	public List<ProgramScheduled> findByStartDate(@PathVariable("startdate")String startDate) {
		if(pgser.findByStartDate(startDate)==null) {
			throw new ProgramScheduledNotFoundException("ProgramSchedule not found with given Start Date:"+startDate);
	}
		return pgser.findByStartDate(startDate);
	}

	@GetMapping("/programscheduled/colname/{clname}")
	public List<ProgramScheduled> findBycollegeName(@PathVariable("clname") String collegeName)  {
		if(pgser.findByCollegeName(collegeName)== null) {
			throw new ProgramScheduledNotFoundException("Program scheduled not found for id:"+collegeName);
		}
		return pgser.findByCollegeName(collegeName);
	}	
	
}
