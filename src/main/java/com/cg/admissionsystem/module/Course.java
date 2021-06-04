package com.cg.admissionsystem.module;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CourseEntity class
 * 
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

	/**
	 * Creating Instance variables of class Course
	 */

	@Id
	private int courseId;
	private String courseName;
	private String description;
	private String eligibility;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "c_id")
	private List<Branch> branch = new ArrayList<>();

	public Course(int courseId, String courseName, String description, String eligibility) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.eligibility = eligibility;
	}
	
	

}
