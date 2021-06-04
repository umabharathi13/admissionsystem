package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.repository.IBranchRepository;

/**
 * Branch Service
 * 
 *
 */

@Service
public class BranchServiceImpl implements IBranchService {

	@Autowired
	IBranchRepository brrep;

	/**
	 * Used to Store the Branch passed as parameter from the Controller function
	 * 
	 * @param Branch
	 * @return
	 */
	@Override
	public Branch save(Branch branch) {
		return brrep.save(branch);
	}

	/**
	 * used to delete the Branch based on the given ID
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Branch deleteByBranchId(int branchId) {
		Optional<Branch> bo = brrep.findById(branchId);
		if (!bo.isPresent()) {
			return null;
		}
		brrep.deleteById(branchId);
		return bo.get();
	}

	/**
	 * This function will retrieve the Branch on basis of given Id
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Branch getByBranchId(int branchId) {
		Optional<Branch> bo = brrep.findById(branchId);
		if (!bo.isPresent()) {
			return null;
		}
		return bo.get();
	}

	/**
	 * To List all the Branch called from the controller class and send back to the
	 * Controller
	 * 
	 * @return
	 */
	@Override
	public List<Branch> findAll() {
		return brrep.findAll();
	}

	/**
	 * Used to update Branch based on the given Id
	 * 
	 * @param id
	 * @param Branch
	 * @return
	 */
	@Override
	public Branch updateBranch(Branch branch) {
		Optional<Branch> b = brrep.findById(branch.getBranchId());
		if (!b.isPresent()) {
			return null;
		}
		b.get().setBranchName(branch.getBranchName());
		b.get().setBranchDescription(branch.getBranchDescription());
		return brrep.save(b.get());
	}

	/**
	 * This function will retrieve the Branch on basis of given branchName
	 * 
	 * @param branchName
	 * @return
	 */
	@Override
	public Branch findByName(String branchName) {
		Branch b = brrep.findByName(branchName);
		if (b == null) {
			return null;
		}
		return brrep.findByName(branchName);
	}

	/**
	 * used to delete the Branch based on the given ID
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public void deleteBranchByBranchName(String branchName) {
		Branch bo = brrep.findByName(branchName);
		int a = bo.getBranchId();
		if (a != 0) {
			brrep.deleteBranchByBranchName(branchName);
		}
	}

	/**
	 * Used to update BranchName based on the given Id
	 * 
	 * @param id
	 * @param Branch
	 * @return
	 */
	@Override
	public Branch updateBranchName(int branchId, Branch branch) {
		Optional<Branch> b = brrep.findById(branch.getBranchId());
		if (!b.isPresent()) {
			return null;
		}
		b.get().setBranchName(branch.getBranchName());
		// b.get().setBranchDescription(branch.getBranchDescription());
		return brrep.save(b.get());
	}

}
