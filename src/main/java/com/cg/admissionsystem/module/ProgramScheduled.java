package com.cg.admissionsystem.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class ProgramScheduled {
	@Id
	private int scheduleId;
	private String startDate;
	private String endDate;
	private String programSchedule;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="program_id")
	private Program program;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="course_id")
	private Course course;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="branch_id")
	private Branch branch;
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="university_id")
	private University university;	
	
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="college_id")
	private College college;
		
	public ProgramScheduled() {}

public ProgramScheduled(int scheduleId, String startDate, String endDate, String programSchedule) {
	super();
	this.scheduleId = scheduleId;
	this.startDate = startDate;
	this.endDate = endDate;
	this.programSchedule = programSchedule;
}


public ProgramScheduled(int scheduleId, String startDate, String endDate, String programSchedule, Program program, Course course, University university) {
	super();
	this.scheduleId = scheduleId;
	this.startDate = startDate;
	this.endDate = endDate;
	this.programSchedule = programSchedule;
	this.program = program;
	this.course = course;
	this.university = university;
}

public ProgramScheduled(int scheduleId, String startDate, String endDate, String programSchedule, Program program, Course course, University university, College college) {
	super();
	this.scheduleId = scheduleId;
	this.startDate = startDate;
	this.endDate = endDate;
	this.programSchedule = programSchedule;
	this.program = program;
	this.course = course;
	this.university = university;
	this.college = college;
}


public ProgramScheduled(int scheduleId, String startDate, String endDate, String programSchedule, Program program,
		Course course, Branch branch, University university, College college) {
	super();
	this.scheduleId = scheduleId;
	this.startDate = startDate;
	this.endDate = endDate;
	this.programSchedule = programSchedule;
	this.program = program;
	this.course = course;
	this.branch = branch;
	this.university = university;
	this.college = college;
}

public int getScheduleId() {
	return scheduleId;
}

public void setScheduleId(int scheduleId) {
	this.scheduleId = scheduleId;
}

public String getStartDate() {
	return startDate;
}

public void setStartDate(String startDate) {
	this.startDate = startDate;
}

public String getEndDate() {
	return endDate;
}

public void setEndDate(String endDate) {
	this.endDate = endDate;
}

public String getProgramSchedule() {
	return programSchedule;
}

public void setProgramSchedule(String programSchedule) {
	this.programSchedule = programSchedule;
}
@JsonManagedReference
public Program getProgram() {
	return program;
}

public void setProgram(Program program) {
	this.program = program;
}

public College getCollege() {
	return college;
}

public void setCollege(College college) {
	this.college = college;
}

@Override
public String toString() {
	return "ProgramScheduled [scheduleId=" + scheduleId + ", startDate=" + startDate + ", endDate=" + endDate
			+ ", programSchedule=" + programSchedule + ", program=" + program + ", course=" + course + ", branch="
			+ branch + ", university=" + university + ", college=" + college + "]";
}


}


	