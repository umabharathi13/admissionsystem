package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.service.IBranchService;

@SpringBootTest
class BranchT {

	org.apache.logging.log4j.Logger logger = LogManager.getLogger(BranchT.class);

	@Autowired
	IBranchService brser;

	// view all branches test
	@Test
	@Disabled
	void testfindAll() {
		List<Branch> b = brser.findAll();
		for (Branch b1 : b) {
			logger.info(b1);
		}
		assertEquals(21, b.size());
	}

	// get Branch by branchId test
	@Test
	@Disabled
	void testFindBranchById() {
		Branch b = brser.getByBranchId(101);
		logger.info(b);
		assertEquals("EEE", b.getBranchName());
	}

	// add new Branch test
	@Test
	@Disabled
	void testCreateBranch() {
		Branch branch = new Branch(599, "InfTech", "ST");
		Branch b = brser.save(branch);
		logger.info(b);
		assertEquals(675, b.getBranchId());
	}

	// update Branch based on Id test
	@Test
	@Disabled
	void updateBranchTest() {
		Branch b = new Branch();
		b.setBranchId(599);
		b.setBranchName("S.T");
		b.setBranchDescription("INFO");
		Branch b1 = brser.updateBranch(b);
		logger.info(b1);
		assertEquals(599, b1.getBranchId());
	}

	// delete branch by branchId test
	@Test
	@Disabled
	void deleteBranchIdTest() {
		brser.deleteByBranchId(464);
		logger.info("deleted");
	}

	// get Branch by branchName test
	@Test
	@Disabled
	void getdetByNameTest() {
		Branch b = brser.findByName("ECE");
		logger.info(b);
		assertEquals("ECE", b.getBranchName());
	}

	// delete Branch by branchName test
	@Test
	@Disabled
	void deleteBranchNameTest() {
		brser.deleteBranchByBranchName("IT");
		logger.info("Deleted");
	}

}
