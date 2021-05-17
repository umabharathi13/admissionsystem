package com.cg.admissionsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.admissionsystem.module.Application;
@Repository

public interface IApplicationRepository extends JpaRepository<Application, Integer > {

	public Application findByEmailId(String emailId);
	

	public List<Application> findByApplicationStatus(String applicationStatus);
	
	
	
	@Query(value="delete from Application WHERE email_Id=:email_id",nativeQuery=true)
	Application deleteApplicationByEmailId(@Param("email_id")String emailId);
	

}
