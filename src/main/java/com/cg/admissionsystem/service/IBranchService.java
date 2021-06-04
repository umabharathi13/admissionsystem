package com.cg.admissionsystem.service;

import java.util.List;

import com.cg.admissionsystem.module.Branch;

public interface IBranchService {

	/**
	 * Methods to be override by the implementing class
	 * 
	 */

	Branch save(Branch branch);

	Branch deleteByBranchId(int branchId);

	Branch getByBranchId(int branchId);

	List<Branch> findAll();

	Branch updateBranch(Branch branch);

	Branch findByName(String branchName);

	void deleteBranchByBranchName(String branchName);

	Branch updateBranchName(int branchId, Branch branch);

}
