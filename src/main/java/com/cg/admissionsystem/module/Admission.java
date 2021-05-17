package com.cg.admissionsystem.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Admission {
	@Id
	private int admissionId;
	private String emailId;
	private String admissionStatus;//Confirm after payment done;
	private String year;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="college_id")  
	private College college;
	
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="course_id")  
	private Course course;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="program_id")  
	private Program program;
	
	
	public Admission(int admissionId,String admissionStatus,String emailId,String year) {
		super();
		this.emailId = emailId;
		this.admissionId = admissionId;
		this.admissionStatus = admissionStatus;
		this.year = year;
	}
	
	
	public Admission(int admissionId, String emailId, String admissionStatus, String year, College college,
			Course course, Program program) {
		super();
		this.admissionId = admissionId;
		this.emailId = emailId;
		this.admissionStatus = admissionStatus;
		this.year = year;
		this.college = college;
		this.course = course;
		this.program = program;
	}


	public Admission() {
		super();
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}
	public String getAdmissionStatus() {
		return admissionStatus;
	}
	public void setAdmissionStatus(String admissionStatus) {
		this.admissionStatus = admissionStatus;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	@Override
	public String toString() {
		return "Admission [admissionId=" + admissionId + ", emailId=" + emailId + ", admissionStatus=" + admissionStatus
				+ ", year=" + year + ", college=" + college + ", course=" + course + ", program=" + program + "]";
	}
	

}

