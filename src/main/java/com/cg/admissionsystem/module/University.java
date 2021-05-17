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
public class University {
	
	@Id
    private int universityId ;
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="address_id")  
	private Address collegeAddress;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="college_id")  
	private College college;
	
    public University() {}
	public University(String name,int universityId) {
		this.name=name;
		this.universityId=universityId;
	}
	
	public University(int universityId, String name, Address collegeAddress, College college) {
		super();
		this.universityId = universityId;
		this.name = name;
		this.collegeAddress = collegeAddress;
		this.college = college;
	}
	public int getUniversityId() {
		return universityId;
	}
	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getCollegeAddress() {
		return collegeAddress;
	}
	public void setCollegeAddress(Address collegeAddress) {
		this.collegeAddress = collegeAddress;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "University [universityId=" + universityId + ", name=" + name + ", collegeAddress=" + collegeAddress
				+ ", college=" + college + "]";
	}
	
}
