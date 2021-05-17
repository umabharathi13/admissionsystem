package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.admissionsystem.module.Application;
import com.cg.admissionsystem.repository.IApplicationRepository;

@Service
public class ApplicationServiceImpl implements IApplicationService {
	
	
	@Autowired
	IApplicationRepository appRepo;
	

	@Override
	public Application addApplication(Application application) {
		
		return appRepo.save(application);
	}

	@Override
	public List<Application> viewAllApplicationDetails() {
		return appRepo.findAll();
	}
	
	@Override
	public Application getApplicationById(int applicationId) {
		Optional<Application> app = appRepo.findById(applicationId);
		if(!app.isPresent()) {
			return null;
		}
		return app.get();
	}

	
	@Override
	public Application updateApplicationStatus(int applicationId, Application application) {
		Optional<Application> app = appRepo.findById(applicationId);
		if(!app.isPresent()) {
			return null;
		}
		app.get().setApplicationStatus(application.getApplicationStatus());
		return appRepo.save(app.get());
	}
	
	@Override
	public Application findByEmailId(String emailId) {
		Application app=appRepo.findByEmailId(emailId);
		if(app==null) {
			return null;
		}
		return appRepo.findByEmailId(emailId);
	}

	@Override
	public List<Application> findByApplicationStatus(String applicationStatus) {
		List<Application> app=appRepo.findByApplicationStatus(applicationStatus);
		if(app.isEmpty()) {
			return null;
		}
		return appRepo.findByApplicationStatus(applicationStatus);
	}
	
	@Override
	public Application deleteApplicationById(int applicationId) {
		Optional<Application> app = appRepo.findById(applicationId);
		if(!app.isPresent()) {
			return null;
		}
		appRepo.deleteById(applicationId);
		return app.get();
	}
		
	@Override
	public Application deleteApplicationByEmailId(String emailId) {
		Application app = appRepo.findByEmailId(emailId);
		if(app==null) {
			return null;
		}
		appRepo.deleteApplicationByEmailId(emailId);	
		return app;
	}	
	


}
