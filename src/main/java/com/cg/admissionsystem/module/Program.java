package com.cg.admissionsystem.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.cg.admissionsystem.module.ProgramScheduled;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Program {
	@Id
	private int programId;	
	private String programName;	
	private String programDuration;
	private String degreeOffered;		
	private String programDescription;	
	private String programEligibility;
	private String programStatus;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private ProgramScheduled programScheduled;
	
	public Program() {}
	
	public Program(int programId, String programName, String programDuration, String degreeOffered,
			String programDescription, String programEligibility, String programStatus) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.programDuration = programDuration;
		this.degreeOffered = degreeOffered;
		this.programDescription = programDescription;
		this.programEligibility = programEligibility;
		this.programStatus = programStatus;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getProgramDuration() {
		return programDuration;
	}

	public void setProgramDuration(String programDuration) {
		this.programDuration = programDuration;
	}

	public String getDegreeOffered() {
		return degreeOffered;
	}

	public void setDegreeOffered(String degreeOffered) {
		this.degreeOffered = degreeOffered;
	}

	public String getProgramDescription() {
		return programDescription;
	}

	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}

	public String getProgramEligibility() {
		return programEligibility;
	}

	public void setProgramEligibility(String programEligibility) {
		this.programEligibility = programEligibility;
	}

	public String getProgramStatus() {
		return programStatus;
	}

	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}
	@JsonBackReference
	public ProgramScheduled getProgramScheduled() {
		return programScheduled;
	}

	public void setProgramScheduled(ProgramScheduled programScheduled) {
		this.programScheduled = programScheduled;
	}

	@Override
	public String toString() {
		return "Program [programId=" + programId + ", programName=" + programName + ", programDuration="
				+ programDuration + ", degreeOffered=" + degreeOffered + ", programDescription=" + programDescription
				+ ", programEligibility=" + programEligibility + ", programStatus=" + programStatus
				+ ", programScheduled=" + programScheduled + "]";
	}
	
}
	