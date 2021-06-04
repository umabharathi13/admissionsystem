package com.cg.admissionsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.admissionsystem.module.College;

@Repository
public interface ICollegeRepository extends JpaRepository<College, Integer> {

	@Query("select c from College c where c.collegeName=:clname")
	College findBycollegeName(@Param("clname") String collegeName);

}
