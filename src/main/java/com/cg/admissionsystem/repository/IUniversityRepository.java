package com.cg.admissionsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.admissionsystem.module.University;

@Repository
public interface IUniversityRepository extends JpaRepository<University, Integer> {

	@Query(value = "select * from university inner join college on university.college_id=college.college_reg_id where college.college_name =:c", nativeQuery = true)
	List<University> findBycollegeName(@Param("c") String collegeName);

}