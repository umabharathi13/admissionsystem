package com.cg.admissionsystem.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.admissionsystem.module.Application;
import com.cg.admissionsystem.repository.IApplicationRepository;

/**
 * Application Service
 */
@Service
public class ApplicationServiceImpl implements IApplicationService {

	@Autowired
	IApplicationRepository appRepo;

	/**
	 * To store the application
	 */
	@Override
	public Application addApplication(Application application) {

		return appRepo.save(application);
	}

	/**
	 * To List all the application called from the controller class and send back to
	 * the Controller
	 */
	@Override
	public List<Application> viewAllApplicationDetails() {
		return appRepo.findAll();
	}

	/**
	 * Get and retrieve a specific Application based on the given id else throws
	 * ApplicationNotFoundException
	 * 
	 * @throws ApplicationNotFoundException
	 */
	@Override
	public Application getApplicationById(int applicationId) {
		Optional<Application> app = appRepo.findById(applicationId);
		if (!app.isPresent()) {
			return null;
		}
		return app.get();
	}

	/**
	 * To update the Application based on the given id and object
	 * 
	 * @throws ApplicationNotFoundException
	 */
	@Override
	public Application updateApplicationStatus(int applicationId, Application application) {
		Optional<Application> app = appRepo.findById(applicationId);
		if (!app.isPresent()) {
			return null;
		}
		app.get().setApplicationStatus(application.getApplicationStatus());
		return appRepo.save(app.get());
	}

	/**
	 * Get and retrieve a specific Application based on the given Email-id else
	 * throws ApplicationNotFoundException
	 * 
	 * @throws ApplicationNotFoundException
	 */
	@Override
	public Application findByEmailId(String emailId) {
		Application app = appRepo.findByEmailId(emailId);
		if (app == null) {
			return null;
		}
		return appRepo.findByEmailId(emailId);
	}

	/**
	 * Get and retrieve a specific Application based on the given applicationStatus
	 * else throws ApplicationNotFoundException
	 * 
	 * @throws ApplicationNotFoundException
	 */
	@Override
	public List<Application> findByApplicationStatus(String applicationStatus) {
		List<Application> app = appRepo.findByApplicationStatus(applicationStatus);
		if (app.isEmpty()) {
			return null;
		}
		return appRepo.findByApplicationStatus(applicationStatus);
	}

	/**
	 * Delete Application by given Id else throws ApplicationNotFoundException
	 * 
	 * @throws ApplicationNotFoundException
	 */
	@Override
	public Application deleteApplicationById(int applicationId) {
		Optional<Application> app = appRepo.findById(applicationId);
		if (!app.isPresent()) {
			return null;
		}
		appRepo.deleteById(applicationId);
		return app.get();
	}

}
