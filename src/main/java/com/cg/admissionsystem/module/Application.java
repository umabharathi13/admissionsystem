package com.cg.admissionsystem.module;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Application
{
    @Id
	private int applicationId;
	private String applicantFullName;
	private LocalDate dateOfBirth;
	private String highestQualification;
	private double finalYearPercentage;
	private String goals;
	private String emailId;
	private String applicationStatus;
	private LocalDate dateOfInterview;
	private String applicantInterviewFeedback;
		
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="payment_id")
	private Payment payment;
	
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="schedule_id")
	private ProgramScheduled programscheduled;
	
	public Application() {}
	
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
	
	
	
	public Application(int applicationId, String applicantFullName, LocalDate dateOfBirth, String highestQualification,
			double finalYearPercentage, String goals, String emailId, String applicationStatus,
			LocalDate dateOfInterview, String applicantInterviewFeedback, 
			ProgramScheduled programscheduled) {
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

	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getApplicantFullName() {
		return applicantFullName;
	}
	public void setApplicantFullName(String applicantFullName) {
		this.applicantFullName = applicantFullName;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getHighestQualification() {
		return highestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
	public double getFinalYearPercentage() {
		return finalYearPercentage;
	}
	public void setFinalYearPercentage(double finalYearPercentage) {
		this.finalYearPercentage = finalYearPercentage;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public LocalDate getDateOfInterview() {
		return dateOfInterview;
	}
	public void setDateOfInterview(LocalDate dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}
	public String getApplicantInterviewFeedback() {
		return applicantInterviewFeedback;
	}
	public void setApplicantInterviewFeedback(String applicantInterviewFeedback) {
		this.applicantInterviewFeedback = applicantInterviewFeedback;
	}
	
	@JsonBackReference
	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", applicantFullName=" + applicantFullName
				+ ", dateOfBirth=" + dateOfBirth + ", highestQualification=" + highestQualification
				+ ", finalYearPercentage=" + finalYearPercentage + ", goals=" + goals + ", emailId=" + emailId
				+ ", applicationStatus=" + applicationStatus + ", dateOfInterview=" + dateOfInterview
				+ ", applicantInterviewFeedback=" + applicantInterviewFeedback + ", payment=" + payment
				+ ", programscheduled=" + programscheduled + "]";
	}

	

	
	
}