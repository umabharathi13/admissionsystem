package com.cg.admissionsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.admissionsystem.module.Admission;
import com.cg.admissionsystem.service.IAdmissionService;

@RestController
public class AdmissionController {
	
	
	
	@Autowired
	IAdmissionService admi;
	// WRITE
			@PostMapping("/admission")
			public Admission addAdmission(@RequestBody Admission admission) {
				return admi.save(admission);
			}
			@GetMapping("/admission")
			public List<Admission> viewAllAdmissionDetails() {
				return admi.viewAll();
}
}
