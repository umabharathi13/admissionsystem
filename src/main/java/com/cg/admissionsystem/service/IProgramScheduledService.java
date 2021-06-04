package com.cg.admissionsystem.service;


import java.util.List;

import com.cg.admissionsystem.module.ProgramScheduled;




public interface IProgramScheduledService {

	ProgramScheduled addProgramSchedule(ProgramScheduled programScheduled);
	List<ProgramScheduled> viewAllProgramScheduleDetails();
	ProgramScheduled getProgramScheduleById(int scheduleId);
    ProgramScheduled deleteProgramScheduleById(int scheduleId);
    ProgramScheduled updateProgramSchedule(int scheduledId,ProgramScheduled programSchedule);
    List<ProgramScheduled> findByStartDate(String startDate);
	List<ProgramScheduled> findByCollegeName(String collegeName);
}
