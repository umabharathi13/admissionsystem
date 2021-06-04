package com.cg.admissionsystem.service;

/**
 * 
 * @author Sherein.J
 *
 */
import java.util.List;

import com.cg.admissionsystem.module.Application;

public interface IApplicationService {

	/**
	 * Methods to be override by the implementing class
	 * 
	 */
	Application addApplication(Application application);

	List<Application> viewAllApplicationDetails();

	Application getApplicationById(int applicationId);

	Application updateApplicationStatus(int id, Application application);

	Application deleteApplicationById(int applicationId);

	Application findByEmailId(String emailId);

	List<Application> findByApplicationStatus(String applicationStatus);

}
