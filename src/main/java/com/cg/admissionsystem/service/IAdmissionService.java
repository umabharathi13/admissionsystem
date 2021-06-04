package com.cg.admissionsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Admission;

@Service
public interface IAdmissionService {

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	Admission save(Admission admission);

	/**
	 * Method to be override by the implementing class
	 * 
	 */
	List<Admission> viewAll();

}