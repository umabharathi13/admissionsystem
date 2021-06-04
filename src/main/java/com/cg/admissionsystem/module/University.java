package com.cg.admissionsystem.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor

public class University {

	@Id
	private int universityId;
	@NotEmpty
	@Size(min = 2, message = "name should have atleast 2 char")
	private String name;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "addr_id")
	private Address universityAddress;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "coll_id")
	private College college;

	public University(String name, int universityId) {
		this.name = name;
		this.universityId = universityId;
	}

	public University(int universityId, String name, Address collegeAddress, College college) {
		super();
		this.universityId = universityId;
		this.name = name;
		this.universityAddress = collegeAddress;
		this.college = college;
	}

	public University(int universityId, String name, Address collegeAddress) {
		super();
		this.universityId = universityId;
		this.name = name;
		this.universityAddress = collegeAddress;
	}

	@Override
	public String toString() {
		return "University [universityId=" + universityId + ", name=" + name + ", collegeAddress=" + universityAddress
				+ ", college=" + college + "]";
	}

}
