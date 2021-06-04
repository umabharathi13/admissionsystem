package com.cg.admissionsystem.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.exception.BranchNotFoundException;
import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.service.IBranchService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BranchController {

	/**
	 * Logger
	 */
	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BranchController.class);

	/**
	 * AutoWiring the BranchService layer to this controller layer of
	 * BranchController
	 * 
	 * @param BranchServiceImpl
	 */
	@Autowired
	IBranchService brser;

	/**
	 * This below function is used to create a new branch and redirects to the
	 * BranchService
	 * 
	 * @param Branch
	 * @return
	 */

	@PostMapping("/branch")
	public ResponseEntity<Branch> addBranch(@RequestBody Branch branch) {
		brser.save(branch);
		logger.info("New Branch is added");
		return ResponseEntity.ok(branch);
	}

	/**
	 * The below functions are used to get all branches,and specific branch based on
	 * the given ID,given branchName and redirects to the BranchService
	 * 
	 * @exception BranchNotFoundException
	 * @param Branch
	 * @return
	 */

	@GetMapping("/branch")
	public ResponseEntity<List<Branch>> findAllBranch() {
		List<Branch> branch = brser.findAll();
		logger.info("Getting all Branch");
		return ResponseEntity.ok().body(branch);
	}

	@GetMapping("/branch/id/{id}")
	public ResponseEntity<Branch> getBranchById(@PathVariable("id") int branchId) {
		if (brser.getByBranchId(branchId) == null) {
			throw new BranchNotFoundException("Branch not found for id:" + branchId);
		}
		Branch branch = brser.getByBranchId(branchId);
		logger.info("Getting Branch for the given branchId:" + branchId);
		return ResponseEntity.ok().body(branch);
	}

	@GetMapping("/branch/bname/{brname}")
	public ResponseEntity<Branch> findByName(@PathVariable("brname") String branchName) {
		if (brser.findByName(branchName) == null) {
			throw new BranchNotFoundException("Branch not found for branchNAME:" + branchName);
		}
		Branch branch = brser.findByName(branchName);
		logger.info("Getting Branch for the given branchName:" + branchName);
		return ResponseEntity.ok().body(branch);
	}

	/**
	 * The below function are used to delete branch by given Id,given branchName and
	 * redirects to the BranchService
	 * 
	 * @exception BranchNotFoundException
	 * @param Branch
	 * @return
	 */

	@DeleteMapping("/branch/did/{id}")
	public Branch deleteBranch(@PathVariable("id") int branchId) {
		if (brser.deleteByBranchId(branchId) == null) {
			throw new BranchNotFoundException("U can't delete because Branch not found for id:" + branchId);
		}
		logger.info("Deleted Branch for the given branchId:" + branchId);
		return brser.deleteByBranchId(branchId);
	}

	@DeleteMapping("/branch/name/{name}")
	public void deleteBranchByBranchName(@PathVariable("name") String branchName) {
		brser.deleteBranchByBranchName(branchName);
		logger.info("Deleted Branch for the given branchName:" + branchName);
	}

	/**
	 * This below function is used to update a specific branch based on the given Id
	 * and redirects to the BranchService
	 * 
	 * @exception BranchNotFoundException
	 * @param Branch
	 * @return
	 */

	@PutMapping("/branch/{id}")
	public ResponseEntity<Branch> updateBranch(@PathVariable("id") int branchId, @RequestBody Branch branch) {
		if (brser.getByBranchId(branchId) == null) {
			throw new BranchNotFoundException("U can't update because Branch not found for id:" + branchId);
		}
		Branch b = brser.updateBranch(branch);
		logger.info("Updated Branch for the given branchId:" + branchId);
		return ResponseEntity.ok(b);
	}

	/**
	 * This below function is used to update a specific branchName based on the
	 * given Id and redirects to the BranchService
	 * 
	 * @exception BranchNotFoundException
	 * @param Branch
	 * @return
	 */

	@PatchMapping("/branch/bid/{id}")
	public ResponseEntity<Branch> updateBranchName(@PathVariable("id") int branchId, @RequestBody Branch branch) {
		if (brser.getByBranchId(branchId) == null) {
			throw new BranchNotFoundException("U can't update because Branch not found for id:" + branchId);
		}
		Branch b = brser.updateBranchName(branchId, branch);
		logger.info("Updated BranchName for the given branchId:" + branchId);
		return ResponseEntity.ok(b);
	}
}
