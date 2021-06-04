package com.cg.admissionsystem.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProgramScheduledEntity class
 * 
 * @author Brindha
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramScheduled {

	/**
	 * creating instance variables for the class programscheduled Entity
	 */
	@Id
	private int scheduleId;
	@NotEmpty
	private String startDate;
	@NotEmpty
	private String endDate;
	private String programSchedule;

	/**
	 * Mapping with ProgramEntity class
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pgm_id")
	private Program program;

	/**
	 * Mapping with CourseEntity class
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cour_id")
	private Course course;

	/**
	 * Mapping with BranchEntity class
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "br_id")
	private Branch branch;

	/**
	 * Mapping with UniversityEntity class
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "univer_id")
	private University university;

	/**
	 * Mapping with CollegeEntity class
	 */
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "colleg_id")
	private College college;

	/**
	 * creating parameterized constructors
	 */
	public ProgramScheduled(int scheduleId, String startDate, String endDate, String programSchedule) {
		super();
		this.scheduleId = scheduleId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.programSchedule = programSchedule;
	}

	@JsonManagedReference
	public Program getProgram() {
		return program;
	}

}
