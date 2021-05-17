package com.cg.admissionsystem.module;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Branch {
	@Id
	private int branchId;
	private String branchName;
	private String branchDescription;
	
	public Branch(){}
	public Branch (int branchId,String branchName,String branchDescription){
		this.branchId=branchId;
		this.branchName=branchName;
		this.branchDescription=branchDescription;
	}
	
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchDescription() {
		return branchDescription;
	}
	public void setBranchDescription(String branchDescription) {
		this.branchDescription = branchDescription;
	}
	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", branchDescription="
				+ branchDescription + "]";
	}
}
	
//@ManyToOne(fetch = FetchType.EAGER)
// @JoinColumn(name = "course_id")
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	
	
