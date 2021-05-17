package com.cg.admissionsystem.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Course {
	@Id
	private int courseId;
	private String courseName;
	private String description;
	private String eligibility;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="course_id")  
	private List<Branch> branch = new ArrayList<>();
	
	public Course(){}
	
	public Course(int courseId, String courseName, String description, String eligibility, List<Branch> branch) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.eligibility = eligibility;
		this.branch = branch;
	}
	
	public Course(int courseId, String courseName, String description, String eligibility) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.eligibility = eligibility;
	}

	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	
	//@JsonManagedReference
	public List<Branch> getBranch() {
		return branch;
	}
	public void setBranch(List<Branch> branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", eligibility=" + eligibility + ", branch=" + branch + "]";
	}
	
	
	
	
}
