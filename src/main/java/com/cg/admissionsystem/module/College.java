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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class College {

	@Id
	private int collegeRegId;
	@NotEmpty
	@Size(min = 2, message = "name should have atleast 2 char")
	private String collegeName;

	// OneToOne mapping to get the values from address
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "add_id")
	private Address collegeAddress;

	// OneToOne mapping to get the values from the program
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "colle_id")
	private List<Program> program = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "clge_id")
	private List<Course> course = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER )
	@JoinColumn(name = "university_id")
	private University university;

	public College(int collegeRegId, String collegeName, Address collegeAddress) {
		super();
		this.collegeRegId = collegeRegId;
		this.collegeName = collegeName;
		this.collegeAddress = collegeAddress;
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

	@Override
	public String toString() {
		return "College [collegeRegId=" + collegeRegId + ", collegeName=" + collegeName + ", collegeAddress="
				+ collegeAddress + ", course=" + course + ", university=" + university + "]";
	}

}
