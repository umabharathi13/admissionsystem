package com.cg.admissionsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.exception.BranchNotFoundException;
import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.module.BranchErrorResponse;
import com.cg.admissionsystem.service.IBranchService;

@RestController
public class BranchController {
	
	
	@Autowired
	IBranchService brser;
	
	@PostMapping("/branch")
	public Branch addBranch(@RequestBody Branch branch) {
		return brser.save(branch);
	}
	
	@GetMapping("/branch/id/{id}")
	public Branch getBranchById(@PathVariable("id") int branchId) {
		if(brser.getByBId(branchId)== null) {
			throw new BranchNotFoundException("Branch not found for id:"+branchId);
		}
		return brser.getByBId(branchId);
	}
	
	@DeleteMapping("/branch/did/{id}")
	public Branch deleteBranch(@PathVariable("id") int branchId) {
		if(brser.deleteByBranchId(branchId) == null) {
			throw new BranchNotFoundException("U can't delete because Branch not found for id:" +branchId);
		}
		return brser.deleteByBranchId(branchId);
	}
	
	@GetMapping("/branch")
	public List<Branch> findAllBranch() {
		return brser.findAll();
	}
	
	@PutMapping("/branch/{id}") 
	public Branch updateBranch(@PathVariable("id") int branchId, @RequestBody Branch branch) {
		if(brser.getByBId(branchId)== null) {
			throw new BranchNotFoundException("U can't update because Branch not found for id:"+branchId);
		}
		return brser.update(branch);
	}
	
	@GetMapping("/branch/bname/{brname}")
	public Branch findByName(@PathVariable("brname") String branchName){
		if(brser.findByName(branchName)==null) {
			throw new BranchNotFoundException("Branch not found for branchNAME:"+branchName);
		}
		return brser.findByName(branchName);
	}
	
	@DeleteMapping("/branch/name/{name}")
	public void deleteBranchByBranchName(@PathVariable("name") String branchName) {
		brser.deleteBranchByBranchName(branchName);
	}
	//patch
	@PatchMapping("/branch/bid/{id}")
	public Branch updateBName(@PathVariable("id") int branchId, @RequestBody Branch branch) {
		if(brser.getByBId(branchId)== null) {
			throw new BranchNotFoundException("U can't update because Branch not found for id:"+branchId);
		}
		return brser.updateB(branchId,branch);
	}
}

