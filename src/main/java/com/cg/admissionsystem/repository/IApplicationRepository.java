package com.cg.admissionsystem.repository;

/**
 * User Repository interface extends
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 * 
 * @author Sherein.J
 * 
 */

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.admissionsystem.module.Application;

@Repository
public interface IApplicationRepository extends JpaRepository<Application, Integer> {

	/**
	 * Implementing the method getting the applicationDetails based on emailId
	 */
	public Application findByEmailId(String emailId);

	/**
	 * Implementing the method getting the applicationDetails based on
	 * applicationStatus
	 */
	public List<Application> findByApplicationStatus(String applicationStatus);

}
