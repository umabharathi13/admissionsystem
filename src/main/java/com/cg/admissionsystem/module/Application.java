package com.cg.admissionsystem.module;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ApplicationEntity class
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {
	/**
	 * Creating instance variables for the class ApplicationEntity
	 */
	@Id
	private int applicationId;

	@NotEmpty
	@Size(min = 3, message = "name should have atleast 2 char")
	private String applicantFullName;

	private LocalDate dateOfBirth;

	private String highestQualification;

	private double finalYearPercentage;

	private String goals;

	@NotEmpty
	@Email(message = "EmailId is not valid")
	private String emailId;

	private String applicationStatus;

	private LocalDate dateOfInterview;

	private String applicantInterviewFeedback;

	/**
	 * OneToOne mapping with payment
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "payment_id")
	private Payment payment;

	/**
	 * OneToOne mapping with programScheduled
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "schedule_id")
	private ProgramScheduled programscheduled;

	/**
	 * Creating Parameterized Constructor
	 */
	public Application(int applicationId, String applicantFullName, LocalDate dateOfBirth, String highestQualification,
			double finalYearPercentage, String goals, String emailId, String applicationStatus,
			LocalDate dateOfInterview, String applicantInterviewFeedback) {
		super();
		this.applicationId = applicationId;
		this.applicantFullName = applicantFullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.finalYearPercentage = finalYearPercentage;
		this.goals = goals;
		this.emailId = emailId;
		this.applicationStatus = applicationStatus;
		this.dateOfInterview = dateOfInterview;
		this.applicantInterviewFeedback = applicantInterviewFeedback;
	}

	/**
	 * Creating Parameterized Constructor
	 */
	public Application(int applicationId, String applicantFullName, LocalDate dateOfBirth, String highestQualification,
			double finalYearPercentage, String goals, String emailId, String applicationStatus,
			LocalDate dateOfInterview, String applicantInterviewFeedback, ProgramScheduled programscheduled) {
		super();
		this.applicationId = applicationId;
		this.applicantFullName = applicantFullName;
		this.dateOfBirth = dateOfBirth;
		this.highestQualification = highestQualification;
		this.finalYearPercentage = finalYearPercentage;
		this.goals = goals;
		this.emailId = emailId;
		this.applicationStatus = applicationStatus;
		this.dateOfInterview = dateOfInterview;
		this.applicantInterviewFeedback = applicantInterviewFeedback;
		this.programscheduled = programscheduled;
	}

	/**
	 * JsonBackReferences are used to display objects with parent child
	 * relationship.
	 * 
	 * @return
	 */
	@JsonManagedReference
	public Payment getPayment() {
		return payment;
	}

	/**
	 * Implementing and overriding toString to retrieve all values in the instance
	 * of Application Class
	 */
	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", applicantFullName=" + applicantFullName
				+ ", dateOfBirth=" + dateOfBirth + ", highestQualification=" + highestQualification
				+ ", finalYearPercentage=" + finalYearPercentage + ", goals=" + goals + ", emailId=" + emailId
				+ ", applicationStatus=" + applicationStatus + ", dateOfInterview=" + dateOfInterview
				+ ", applicantInterviewFeedback=" + applicantInterviewFeedback + "]";
	}

}