package com.cg.admissionsystem.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * AdmissionEntity class
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admission {

	/**
	 * creating instance variables for the class AdmissionEntity
	 */
	@Id
	private int admissionId;
	@NotEmpty
	@Email(message = "please enter emailid")
	private String emailId;
	private String admissionStatus;// Confirm after payment done;
	private String year;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "college_id")
	private College college;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id")
	private Course course;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "program_id")
	private Program program;

	public Admission(int admissionId, String admissionStatus, String emailId, String year) {
		super();
		this.emailId = emailId;
		this.admissionId = admissionId;
		this.admissionStatus = admissionStatus;
		this.year = year;
	}
}
