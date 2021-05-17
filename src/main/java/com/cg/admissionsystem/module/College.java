package com.cg.admissionsystem.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class College {
	
	@Id
	private int collegeRegId;
	private String collegeName;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="address_id")  
	private Address collegeAddress;	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="clg_id")  
	private List<Program> program=new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="college_id")  
	private List<Course> course = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="c_id")
	private University university;
	
	
	
    //private ArrayList<Program> programList;
	//private University universityName;
	
	public College(){}
	public College(int collegeRegId, String collegeName, Address collegeAddress) {
		super();
		this.collegeRegId = collegeRegId;
		this.collegeName = collegeName;
		this.collegeAddress =collegeAddress;
	}
	
	public College(int collegeRegId, String collegeName, Address collegeAddress, List<Course> course) {
		super();
		this.collegeRegId = collegeRegId;
		this.collegeName = collegeName;
		this.collegeAddress = collegeAddress;
		this.course = course;
	}
	public College(int collegeRegId, String collegeName, List<Course> course) {
		super();
		this.collegeRegId = collegeRegId;
		this.collegeName = collegeName;
		this.course = course;
	}
	public College(int collegeRegId, String collegeName, List<Course> course, Address collegeAddress,
			University university) {
		super();
		this.collegeRegId = collegeRegId;
		this.collegeName = collegeName;
		this.course = course;
		this.collegeAddress = collegeAddress;
		this.university = university;
	}
	
	public College(int collegeRegId, String collegeName, Address collegeAddress, List<Program> program,
			List<Course> course, University university) {
		super();
		this.collegeRegId = collegeRegId;
		this.collegeName = collegeName;
		this.collegeAddress = collegeAddress;
		this.program = program;
		this.course = course;
		this.university = university;
	}
	public int getCollegeRegId() {
		return collegeRegId;
	}
	public void setCollegeRegId(int collegeRegId) {
		this.collegeRegId = collegeRegId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	public Address getCollegeAddress() {
		return collegeAddress;
	}
	public void setCollegeAddress(Address collegeAddress) {
		this.collegeAddress = collegeAddress;
	}
	
	public List<Program> getProgram() {
		return program;
	}
	public void setProgram(List<Program> program) {
		this.program = program;
	}
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	@Override
	public String toString() {
		return "College [collegeRegId=" + collegeRegId + ", collegeName=" + collegeName + ", collegeAddress="
				+ collegeAddress + ", program=" + program + ", course=" + course + ", university=" + university + "]";
	}
}
