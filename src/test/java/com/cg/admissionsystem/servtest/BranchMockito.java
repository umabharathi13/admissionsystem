package com.cg.admissionsystem.servtest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.admissionsystem.module.Branch;
import com.cg.admissionsystem.repository.IBranchRepository;
import com.cg.admissionsystem.service.BranchServiceImpl;

@ExtendWith(SpringExtension.class)
class BranchMockito {
	
	@InjectMocks
	BranchServiceImpl brser;
	@MockBean
	IBranchRepository brrep;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void createTest() {
		Branch b=new Branch(101,"EEE","Electrical engineering");
		Mockito.when(brrep.save(b)).thenReturn(b);
		Branch br=brrep.save(b);
		assertEquals(101,br.getBranchId());
		assertEquals("EEE", br.getBranchName());
		assertEquals("Electrical engineering", br.getBranchDescription());
	}
	@Test
	void viewTest() {
		Branch b = new Branch(101, "EEE", "Electrical");
		Branch b1 = new Branch(151, "CIVIL", "Civil Eng");
		List<Branch> brlist = new ArrayList<>();
		brlist.add(b);
		brlist.add(b1);
		Mockito.when(brrep.findAll()).thenReturn(brlist);
		List<Branch> branches = brser.findAll();
		assertEquals(2, branches.size());
	}
	@Test
	void getByIdTest() {
		Branch b=new Branch(101,"EEE","Electrical");
		Mockito.when(brrep.findById(101)).thenReturn(Optional.of(b));
		Branch b1=brser.getByBId(101);
		assertEquals("Electrical", b1.getBranchDescription());
		
	}
	@Test
	void deleteTest() {
		Branch b=new Branch(101,"EEE","Electrical");
		Mockito.when(brrep.findById(101)).thenReturn(Optional.of(b));
		brrep.deleteById(101);
		Branch b1=brser.deleteByBranchId(101);
		assertEquals("Electrical", b1.getBranchDescription());
	}
	@Test
	void updateTest() {
		Branch b=new Branch(101,"EEE","Electrical");
		Mockito.when(brrep.findById(101)).thenReturn(Optional.of(b));
		Mockito.when(brrep.save(b)).thenReturn(b);
		Branch br=brser.update(b);
		assertEquals(101,br.getBranchId());
		assertEquals("EEE", br.getBranchName());
		assertEquals("Electrical", br.getBranchDescription());
	}
	@Test
	void getByNameTest() {
		Branch b = new Branch(101, "EEE", "Electrical");
		Mockito.when(brrep.findByName("EEE")).thenReturn(b);
		Branch b2=brser.findByName("EEE");
		assertEquals("EEE",b2.getBranchName());
	}
	@Test
	void deleteByNameTest() {
		Branch b=new Branch(101,"EEE","Electrical");
		Mockito.when(brrep.findByBranchName("EEE")).thenReturn(Optional.of(b));
		brrep.deleteBranchByBranchName("EEE");
	}
	
	

}
