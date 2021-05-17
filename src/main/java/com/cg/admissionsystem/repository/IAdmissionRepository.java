package com.cg.admissionsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.admissionsystem.module.Admission;


@Repository

	public interface IAdmissionRepository extends JpaRepository<Admission, Integer > 
	{

	Admission findByadmissionId(int admissionId);

}
