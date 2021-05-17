package com.cg.admissionsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Admission;
@Service
public interface IAdmissionService {
	Admission save(Admission admission);
	List<Admission> viewAll();
	
}