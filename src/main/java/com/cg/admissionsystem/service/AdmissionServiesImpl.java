package com.cg.admissionsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Admission;
import com.cg.admissionsystem.repository.IAdmissionRepository;

/**
 * Admission Service
 *
 */
@Service
public class AdmissionServiesImpl implements IAdmissionService {

	@Autowired
	IAdmissionRepository admi;

	/**
	 * To store the admission
	 */

	@Override
	public Admission save(Admission admission) {
		// TODO Auto-generated method stub
		return admi.save(admission);
	}

	/**
	 * To List all the admission called from the controller class and send back to
	 * the Controller
	 */
	@Override
	public List<Admission> viewAll() {
		// TODO Auto-generated method stub
		return admi.findAll();
	}
}
