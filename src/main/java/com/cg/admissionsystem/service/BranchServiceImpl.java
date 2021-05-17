package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.repository.IBranchRepository;
@Service
public class BranchServiceImpl implements IBranchService {
	
	@Autowired
	IBranchRepository brrep;

	@Override
	public Branch save(Branch branch) {
		return brrep.save(branch);
	}

	@Override
	public Branch deleteByBranchId(int branchId) {
		Optional<Branch> bo=brrep.findById(branchId);
		if(!bo.isPresent()) {
		return null;
		}
		brrep.deleteById(branchId);
		return bo.get();
	}

	@Override
	public Branch getByBId(int branchId) {
		Optional <Branch> bo = brrep.findById(branchId);
	    if(!bo.isPresent()) {
	    	return null;
	    }
	    return bo.get();
	}

	@Override
	public List<Branch> findAll() {
		return brrep.findAll();
	}

	@Override
	public Branch update(Branch branch) {
		Optional<Branch> b = brrep.findById(branch.getBranchId());
		if(!b.isPresent()) {
			return null;
		}
		b.get().setBranchName(branch.getBranchName());
		b.get().setBranchDescription(branch.getBranchDescription());
		return brrep.save(b.get());
	}
	
	@Override
	public Branch findByName(String branchName) {
		Branch b=brrep.findByName(branchName);
		if(b==null) {
			return null;
		}
		return brrep.findByName(branchName);
	}

	@Override
	public void deleteBranchByBranchName(String branchName) {
		Branch bo=brrep.findByName(branchName);
		int a=bo.getBranchId();
		if(a!=0) {
		brrep.deleteBranchByBranchName(branchName);}
	}
//patch
	@Override
	public Branch updateB(int branchId,Branch branch) {
		Optional<Branch> b = brrep.findById(branch.getBranchId());
		if(!b.isPresent()) {
			return null;
		}
		b.get().setBranchName(branch.getBranchName());
		//b.get().setBranchDescription(branch.getBranchDescription());
		return brrep.save(b.get());
	}

	
}
