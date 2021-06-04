package com.cg.admissionsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.admissionsystem.module.Course;
import com.cg.admissionsystem.module.Program;

/**
 * Program Repository interface extends
 * {@link org.springframework.data.jpa.repository.JpaRepository}.
 * 
 * @author Brindha
 * 
 */
@Repository
public interface IProgramRepository extends JpaRepository<Program, Integer> {

	List<Program> findByProgramName(String programName);

	List<Program> findByProgramEligibility(String programEligibility);

	@Query("select p from Program p where p.programName=:n")
	public Program getProgramByName(@Param("n") String programName);

	@Query(value = "delete from Program where program_name=:program_name", nativeQuery = true)
	List<Program> deleteProgramByProgramName(@Param("program_name") String programName);

	@Query(value = "select * from program inner join college on program.clg_id=college.college_reg_id where college.college_name =:n", nativeQuery = true)
	public List<Program> findBycollegeName(@Param("n") String collegeName);

}
