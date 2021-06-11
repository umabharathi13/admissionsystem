package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Address;
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

	@Override
	public Admission updateAdmission(Admission admis) {
		Optional<Admission> as = admi.findById(admis.getAdmissionId());
		if (!as.isPresent()) {
			return null;
		}
		as.get().setAdmissionId(admis.getAdmissionId());
		as.get().setEmailId(admis.getEmailId());
		as.get().setAdmissionStatus(admis.getAdmissionStatus());
		as.get().setYear(admis.getYear());
		return admi.save(as.get());
	}

	@Override
	public Admission getAdmissionById(int admissionId) {
		Optional<Admission> opt = admi.findById(admissionId);
		if (!opt.isPresent()) {
			return null;
		}
		return opt.get();
	}

	@Override
	public Admission deleteAdmissionById(int admissionId) {
		Optional<Admission> opt = admi.findById(admissionId);
		if (!opt.isPresent()) {
			return null;
		}
		admi.deleteById(admissionId);
		return opt.get();
	}

}
