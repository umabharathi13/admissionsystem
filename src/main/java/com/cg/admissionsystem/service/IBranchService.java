package com.cg.admissionsystem.service;

import java.util.List;

import com.cg.admissionsystem.module.Branch;

public interface IBranchService {

	Branch save(Branch branch);

	Branch deleteByBranchId(int branchId);

	Branch getByBId(int branchId);

	List<Branch> findAll();

	Branch update(Branch branch);

	Branch findByName(String branchName);
	
	void deleteBranchByBranchName(String branchName);
	
	//patch
	Branch updateB(int branchId,Branch branch);

	//Branch update(int branchId, Branch branch);

}
