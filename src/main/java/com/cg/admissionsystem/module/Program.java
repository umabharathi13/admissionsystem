package com.cg.admissionsystem.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cg.admissionsystem.module.ProgramScheduled;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * ProgramEntity class
 * 
 * @author Brindha
 * 
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {

	/**
	 * creating instance variables for the class AddressEntity
	 */
	@Id
	private int programId;
	@NotEmpty
	@Size(min = 2, message = "name should have atleast 2 char")
	private String programName;
	private String programDuration;
	private String degreeOffered;
	private String programDescription;
	private String programEligibility;
	private String programStatus;

	/**
	 * Mapping with programscheduledEntity class
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ProgramScheduled programScheduled;

	/**
	 * creating parameterized constructors
	 */
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

	@JsonBackReference
	public ProgramScheduled getProgramScheduled() {
		return programScheduled;
	}

	/**
	 * Implementing and overriding toString to retrieve all values in the instance
	 * of Program Class
	 */
	@Override
	public String toString() {
		return "Program [programId=" + programId + ", programName=" + programName + ", programDuration="
				+ programDuration + ", degreeOffered=" + degreeOffered + ", programDescription=" + programDescription
				+ ", programEligibility=" + programEligibility + ", programStatus=" + programStatus + "]";
	}
}
